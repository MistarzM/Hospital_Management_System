package org.example.ehospital.service.impl;

import org.example.ehospital.dto.VisitDto;
import org.example.ehospital.entity.Visit;
import org.example.ehospital.mapper.VisitMapper;
import org.example.ehospital.repo.VisitRepo;
import org.example.ehospital.service.VisitService;
import org.springframework.stereotype.Service;

@Service
public class VisitServiceImpl implements VisitService {
    private final VisitRepo visitRepo;

    public VisitServiceImpl(VisitRepo visitRepo) {
        this.visitRepo = visitRepo;
    }

    @Override
    public VisitDto getVisitByTriageId(Integer triageId) {
        Visit visit = visitRepo.findByTriageId(triageId)
                .orElseThrow(() -> new RuntimeException("Visit not found"));
        return VisitMapper.mapToVisitDto(visit);
    }

    @Override
    public VisitDto updateVisit(Integer triageId, VisitDto updatedVisit) {
        Visit visit = visitRepo.findByTriageId(triageId)
                .orElseThrow(() -> new RuntimeException("Visit not found"));

        visit.setHospitalizationSteps(updatedVisit.getHospitalizationSteps());
        visit.setPrescription(updatedVisit.getPrescription());

        Visit updatedVisitEntity = visitRepo.save(visit);
        return VisitMapper.mapToVisitDto(updatedVisitEntity);
    }
}
