package com.management.system.demo.enums;

public enum ConstantType {
    EMPLOYEE("employee", "employees", "redirect:/employee", "new_employee", "update_employee"),
    EMPLOYER("employer", "employers", "redirect:/employer", "new_employer", "update_employer"),
    DEPARTMENT("department", "departments", "redirect:/department", "new_department", "update_department");


    private String type;
    private String listType;
    private String redirectType;
    private String newType;
    private String updateType;

    ConstantType(String type, String listType, String redirectType, String newType, String updateType) {
        this.type = type;
        this.listType = listType;
        this.redirectType = redirectType;
        this.newType = newType;
        this.updateType = updateType;
    }

    public String getType() {
        return type;
    }

    public String getListType() {
        return listType;
    }

    public String getRedirectType() {
        return redirectType;
    }

    public String getNewType() {
        return newType;
    }

    public String getUpdateType() {
        return updateType;
    }
}
