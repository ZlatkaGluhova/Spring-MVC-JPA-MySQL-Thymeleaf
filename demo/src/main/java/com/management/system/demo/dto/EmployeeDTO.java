package com.management.system.demo.dto;

import com.management.system.demo.enums.Status;

public class EmployeeDTO {
    private long idDTO;
    private String firstNameDTO;
    private String lastNameDTO;
    private String emailDTO;
    private int ageDTO;
    private Status statusDTO;

    public EmployeeDTO() {
    }

    public long getIdDTO() {
        return idDTO;
    }

    public void setIdDTO(long idDTO) {
        this.idDTO = idDTO;
    }

    public String getFirstNameDTO() {
        return firstNameDTO;
    }

    public void setFirstNameDTO(String firstNameDTO) {
        this.firstNameDTO = firstNameDTO;
    }

    public String getLastNameDTO() {
        return lastNameDTO;
    }

    public void setLastNameDTO(String lastNameDTO) {
        this.lastNameDTO = lastNameDTO;
    }

    public String getEmailDTO() {
        return emailDTO;
    }

    public void setEmailDTO(String emailDTO) {
        this.emailDTO = emailDTO;
    }

    public int getAgeDTO() {
        return ageDTO;
    }

    public void setAgeDTO(int ageDTO) {
        this.ageDTO = ageDTO;
    }

    public Status getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(Status statusDTO) {
        this.statusDTO = statusDTO;
    }
}
