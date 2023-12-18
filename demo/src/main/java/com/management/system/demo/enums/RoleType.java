package com.management.system.demo.enums;

public enum RoleType {
    ADMIN("Admin"),
    USER("User");


    private String name;

    RoleType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
