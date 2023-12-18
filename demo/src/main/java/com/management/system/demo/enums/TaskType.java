package com.management.system.demo.enums;

public enum TaskType {
    EPIC("Epic"),
    STORY("Story"),
    TASK("Task");

    private String name;

    TaskType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
