package org.example.ehospital.service;

import org.example.ehospital.dto.TriageDto;

import java.util.List;

public interface TriageService {
    TriageDto createTriage(TriageDto triageDto);
    TriageDto getTriageById(Integer id);

    List<TriageDto> getAllTriages();
    TriageDto updateTriage(Integer triageId, TriageDto triageDto);
    void deleteTriage(Integer triageId);

    List<TriageDto> getPriorityQueue();
}
