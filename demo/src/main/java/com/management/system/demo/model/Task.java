package com.management.system.demo.model;

import com.management.system.demo.enums.TaskStatus;
import com.management.system.demo.enums.TaskType;

import java.time.LocalDateTime;

public class Task {

    private Long id;
    private TaskType type;
    private TaskStatus status;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public Task() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", type=" + type +
                ", status=" + status +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
