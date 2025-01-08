package org.example.ehospital.service.impl;

import org.example.ehospital.dto.TriageDto;
import org.example.ehospital.entity.Triage;
import org.example.ehospital.mapper.TriageMapper;
import org.example.ehospital.repo.TriageRepo;
import org.example.ehospital.service.TriageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TriageServiceImpl implements TriageService {
    private final TriageRepo triageRepo;

    @Autowired
    public TriageServiceImpl(TriageRepo triageRepo) {
        this.triageRepo = triageRepo;
    }
    @Override
    public TriageDto createTriage(TriageDto triageDto) {
        Triage triage = TriageMapper.mapToTriage(triageDto);
        Triage savedTriage = triageRepo.save(triage);
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
}
