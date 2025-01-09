package org.example.ehospital.dto;

public class QueueDto {
    private int id;
    private int triageId;
    private int priorityPoints;
    private String priorityLevel;
    private String status;

    // Konstruktor
    public QueueDto(int id, int triageId, int priorityPoints, String priorityLevel, String status) {
        this.id = id;
        this.triageId = triageId;
        this.priorityPoints = priorityPoints;
        this.priorityLevel = priorityLevel;
        this.status = status;
    }

    public QueueDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTriageId() {
        return this.triageId;
    }

    public void setTriageId(int triageId) {
        this.triageId = triageId;
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


