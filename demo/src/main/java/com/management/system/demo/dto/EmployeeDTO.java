package com.management.system.demo.dto;

import com.management.system.demo.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EmployeeDTO {
    private long idDTO;
    private String firstNameDTO;
    private String lastNameDTO;
    private String emailDTO;
    private int ageDTO;
    private BigDecimal salaryDTO;
    private LocalDateTime createdOnDTO;
    private LocalDateTime updatedOnDTO;
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

    public BigDecimal getSalaryDTO() {
        return salaryDTO;
    }

    public void setSalaryDTO(BigDecimal salaryDTO) {
        this.salaryDTO = salaryDTO;
    }

    public LocalDateTime getCreatedOnDTO() {
        return createdOnDTO;
    }

    public void setCreatedOnDTO(LocalDateTime createdOnDTO) {
        this.createdOnDTO = createdOnDTO;
    }

    public LocalDateTime getUpdatedOnDTO() {
        return updatedOnDTO;
    }

    public void setUpdatedOnDTO(LocalDateTime updatedOnDTO) {
        this.updatedOnDTO = updatedOnDTO;
    }

    public Status getStatusDTO() {
        return statusDTO;
    }

    public void setStatusDTO(Status statusDTO) {
        this.statusDTO = statusDTO;
    }
}
