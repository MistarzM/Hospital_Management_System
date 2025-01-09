package org.example.ehospital.dto;

public class VisitDto {
    private int id;
    private String hospitalizationSteps;
    private String prescription;

    public VisitDto(int id, String hospitalizationSteps, String prescription) {
        this.id = id;
        this.hospitalizationSteps = hospitalizationSteps;
        this.prescription = prescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHospitalizationSteps() {
        return hospitalizationSteps;
    }

    public void setHospitalizationSteps(String hospitalizationSteps) {
        this.hospitalizationSteps = hospitalizationSteps;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
