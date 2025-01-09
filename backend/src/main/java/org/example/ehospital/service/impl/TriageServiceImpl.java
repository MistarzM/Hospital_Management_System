package org.example.ehospital.service.impl;

import org.example.ehospital.dto.TriageDto;
import org.example.ehospital.entity.Queue;
import org.example.ehospital.entity.Triage;
import org.example.ehospital.mapper.TriageMapper;
import org.example.ehospital.repo.QueueRepo;
import org.example.ehospital.repo.TriageRepo;
import org.example.ehospital.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TriageServiceImpl implements TriageService {
    private final TriageRepo triageRepo;
    private final QueueRepo queueRepo;

    @Autowired
    public TriageServiceImpl(TriageRepo triageRepo, QueueRepo queueRepo) {
        this.triageRepo = triageRepo;
        this.queueRepo = queueRepo;
    }

    @Override
    public TriageDto createTriage(TriageDto triageDto) {
        Triage triage = TriageMapper.mapToTriage(triageDto);
        Triage savedTriage = triageRepo.save(triage);

        int priorityPoints = calculatePriorityPoints(triageDto);
        String priorityLevel = determinePriorityLevel(priorityPoints);

        Queue queue = new Queue(savedTriage, priorityPoints, priorityLevel, "WAITING");
        queueRepo.save(queue);

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
