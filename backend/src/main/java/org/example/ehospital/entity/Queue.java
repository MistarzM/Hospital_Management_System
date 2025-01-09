package org.example.ehospital.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "queue")
public class Queue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "triage_id", nullable = false)
    private Triage triage;

    private int priorityPoints;
    private String priorityLevel; // HIGH, MEDIUM, LOW
    private String status; // WAITING, IN_PROGRESS, FINSHED

    public Queue() {
    }

    public Queue(Triage triage, int priorityPoints, String priorityLevel, String status) {
        this.triage = triage;
        this.priorityPoints = priorityPoints;
        this.priorityLevel = priorityLevel;
        this.status = status;
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

    public int getPriorityPoints() {
        return priorityPoints;
    }

    public void setPriorityPoints(int priorityPoints) {
        this.priorityPoints = priorityPoints;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
