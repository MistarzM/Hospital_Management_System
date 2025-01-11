package org.example.ehospital.service;

import org.example.ehospital.dto.VisitDto;

public interface VisitService {
    VisitDto getVisitByTriageId(Integer id);
    VisitDto updateVisit(Integer triageId, VisitDto updatedVisit);
}