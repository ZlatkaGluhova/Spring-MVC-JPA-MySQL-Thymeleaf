package com.management.system.demo.dto;

import com.management.system.demo.model.Employee;

public class FinancialDocumentDTO {

    private Long id;
    private Employee employee;

    public FinancialDocumentDTO() {
    }

    public FinancialDocumentDTO(Long id, Employee employee) {
        this.id = id;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "FinancialDocument{" +
                "id=" + id +
                ", employee=" + employee +
                '}';
    }
}
