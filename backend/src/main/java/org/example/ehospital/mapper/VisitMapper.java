package org.example.ehospital.mapper;

import org.example.ehospital.dto.VisitDto;
import org.example.ehospital.entity.Visit;

public class VisitMapper {
    public  static VisitDto mapToVisitDto(Visit visit) {
        return new VisitDto(
                visit.getId(),
                visit.getHospitalizationSteps(),
                visit.getPrescription()
        );
    }
}
