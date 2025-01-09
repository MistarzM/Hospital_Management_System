package org.example.ehospital.service.impl;

import org.example.ehospital.dto.TriageDto;
import org.example.ehospital.entity.Queue;
import org.example.ehospital.entity.Triage;
import org.example.ehospital.entity.Visit;
import org.example.ehospital.mapper.TriageMapper;
import org.example.ehospital.repo.QueueRepo;
import org.example.ehospital.repo.TriageRepo;
import org.example.ehospital.repo.VisitRepo;
import org.example.ehospital.service.ChatGPTService;
import org.example.ehospital.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TriageServiceImpl implements TriageService {
    private final TriageRepo triageRepo;
    private final QueueRepo queueRepo;
    private final VisitRepo visitRepo;
    private final ChatGPTService chatGPTService;

    @Autowired
    public TriageServiceImpl(TriageRepo triageRepo, QueueRepo queueRepo, VisitRepo visitRepo, ChatGPTService chatGPTService) {
        this.triageRepo = triageRepo;
        this.queueRepo = queueRepo;
        this.visitRepo = visitRepo;
        this.chatGPTService = chatGPTService;
    }

    @Override
    public TriageDto createTriage(TriageDto triageDto) {
        // Mapowanie danych do encji `Triage`
        Triage triage = TriageMapper.mapToTriage(triageDto);
        Triage savedTriage = triageRepo.save(triage);

        // Obliczanie punktów priorytetowych i poziomu priorytetu
        int priorityPoints = calculatePriorityPoints(triageDto);
        String priorityLevel = determinePriorityLevel(priorityPoints);

        // Tworzenie wpisu w tabeli `queue`
        Queue queue = new Queue(savedTriage, priorityPoints, priorityLevel, "WAITING");
        queueRepo.save(queue);

        // Przygotowanie prompta dla ChatGPT
        String prompt = String.format(
                "Based on the following patient data:\n" +
                        "- Name: %s\n" +
                        "- Blood Pressure: %d mmHg\n" +
                        "- Heart Rate: %d bpm\n" +
                        "- Oxygen Saturation: %d%%\n" +
                        "- Description: %s\n\n" +
                        "Please provide the following:\n" +
                        "1. A detailed hospitalization plan with clear, actionable steps.'\n" +
                        "2. A professional prescription, including drug names, doses, and instructions for use. Start the section with the keyword 'PRESCRIPTION:'\n" +
                        "Separate the sections clearly with their respective keywords.\n\n" +
                        "Format the response as follows:\n" +
                        "1. Step one...\n" +
                        "2. Step two...\n\n" +
                        "PRESCRIPTION:\n" +
                        "- Drug Name (Dose, Frequency): Additional instructions\n" +
                        "- Drug Name (Dose, Frequency): Additional instructions\n",
                triageDto.getName(),
                triageDto.getBloodPressure(),
                triageDto.getHeartRate(),
                triageDto.getOxygenSaturation(),
                triageDto.getDescription()
        );

        // Wywołanie ChatGPT API
        Map<String, String> suggestions = chatGPTService.generateSuggestions(prompt);

        Visit visit = new Visit();
        visit.setTriage(savedTriage);
        visit.setHospitalizationSteps(suggestions.get("hospitalizationSteps"));
        visit.setPrescription(suggestions.get("prescription"));
        visitRepo.save(visit);

        return TriageMapper.mapToTriageDto(savedTriage);
    }


    @Override
    public TriageDto getTriageById(Integer id) {
        Triage triage = triageRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Triage not found"));
        return TriageMapper.mapToTriageDto(triage);
    }

    @Override
    public List<TriageDto> getAllTriages() {
        List<Triage> triages = triageRepo.findAll();
        return triages.stream().map((TriageMapper::mapToTriageDto))
                .collect(Collectors.toList());
    }

    @Override
    public TriageDto updateTriage(Integer triageId, TriageDto triageDto) {
        Triage triage = triageRepo.findById(triageId)
                .orElseThrow(() -> new RuntimeException("Triage not found"));

        triage.setName(triageDto.getName());
        triage.setDate(triageDto.getDate());
        triage.setBloodPressure(triageDto.getBloodPressure());
        triage.setHeartRate(triageDto.getHeartRate());
        triage.setOxygenSaturation(triageDto.getOxygenSaturation());
        triage.setDescription(triageDto.getDescription());

        Triage updatedTriage = triageRepo.save(triage);

        return TriageMapper.mapToTriageDto(updatedTriage);

    }

    @Override
    public void deleteTriage(Integer triageId) {
        Triage triage = triageRepo.findById(triageId)
                .orElseThrow(() -> new RuntimeException("Triage not found"));

        triageRepo.deleteById(triage.getId());
    }

    private int calculatePriorityPoints(TriageDto triageDto) {
        int points = 0;

        if (triageDto.getBloodPressure() > 140 || triageDto.getBloodPressure() < 90) {
            points += 3;
        }
        if (triageDto.getHeartRate() > 100 || triageDto.getHeartRate() < 60) {
            points += 2;
        }
        if (triageDto.getOxygenSaturation() < 95) {
            points += 5;
        }

        return points;
    }

    private String determinePriorityLevel(int points) {
        if (points >= 8) {
            return "HIGH";
        } else if (points >= 4) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    @Override
    public List<TriageDto> getPriorityQueue() {
        List<Queue> queueList = queueRepo.findAllByStatusInOrderByPriorityPointsDesc(
                List.of("WAITING", "IN_PROGRESS")
        );

        return queueList.stream()
                .map(queue -> TriageMapper.mapToTriageDto(queue.getTriage()))
                .collect(Collectors.toList());
    }

}
