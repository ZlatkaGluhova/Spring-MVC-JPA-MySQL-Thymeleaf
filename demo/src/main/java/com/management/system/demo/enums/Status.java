package com.management.system.demo.enums;


public enum Status {

    ACTIVE("Active"),
    INACTIVE("Inactive"),
    DELETED("Deleted");

    private String type;

    Status(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
