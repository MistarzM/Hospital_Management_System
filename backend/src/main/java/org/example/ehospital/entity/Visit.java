package org.example.ehospital.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "visit")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "triage_id", nullable = false)
    private Triage triage;

    private String hospitalizationSteps;
    private String prescription;

    public Visit() {

    }

    public Visit(Triage triage, String hospitalizationSteps, String prescription) {
        this.triage = triage;
        this.hospitalizationSteps = hospitalizationSteps;
        this.prescription = prescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Triage getTriage() {
        return triage;
    }

    public void setTriage(Triage triage) {
        this.triage = triage;
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
