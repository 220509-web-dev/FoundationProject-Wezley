package com.revature.taskmaster.dtos;

import com.revature.taskmaster.entities.Task;

public class NewTaskRequest {

    private String title;
    private String description;
    private int pointValue;
    private String creatorId;
    private String assigneeId;
    private String label;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getAssigneeId() {
        return assigneeId;
    }

    public void setAssigneeId(String assigneeId) {
        this.assigneeId = assigneeId;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Task extractResource() {
        return new Task(title, description, pointValue, creatorId, assigneeId, label);
    }

    @Override
    public String toString() {
        return "NewTaskResponse{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", pointValue=" + pointValue +
                ", creatorId='" + creatorId + '\'' +
                ", assigneeId='" + assigneeId + '\'' +
                ", label='" + label + '\'' +
                '}';
    }

}
