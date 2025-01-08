package org.example.ehospital.mapper;

import org.example.ehospital.dto.TriageDto;
import org.example.ehospital.entity.Triage;

public class TriageMapper {

    public static TriageDto mapToTriageDto(Triage triage) {
        return new TriageDto(
                triage.getId(),
                triage.getName(),
                triage.getDate(),
                triage.getBloodPressure(),
                triage.getHeartRate(),
                triage.getOxygenSaturation(),
                triage.getDescription()
        );
    }

    public static Triage mapToTriage(TriageDto triageDto) {
        return new Triage(
                triageDto.getId(),
                triageDto.getName(),
                triageDto.getDate(),
                triageDto.getBloodPressure(),
                triageDto.getHeartRate(),
                triageDto.getOxygenSaturation(),
                triageDto.getDescription()
        );
    }
}