package com.management.system.demo.enums;

public enum RoleType {
    TODO("TODO"),
    IN_PROGRESS("In Progress"),
    DONE("Done");


    private String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
