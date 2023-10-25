package com.management.system.demo.enums;

public enum DepartmentName {
    IT("Information Technology"),
    FINANCE("Financial Service"),
    HR("Human Resources");


    private String name;

    DepartmentName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
