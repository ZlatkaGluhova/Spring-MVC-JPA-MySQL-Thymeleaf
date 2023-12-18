package com.management.system.demo.enums;

public enum TaskStatus {
    TODO("TODO"),
    IN_PROGRESS("In Progress"),
    DONE("Done");


    private String name;

    TaskStatus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
