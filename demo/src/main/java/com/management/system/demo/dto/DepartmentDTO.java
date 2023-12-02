package com.management.system.demo.dto;

import com.management.system.demo.enums.DepartmentName;
import com.management.system.demo.model.Department;
import com.management.system.demo.model.Employer;

public class DepartmentDTO {
    private Long id;
    private DepartmentName departmentName;
    private EmployerDTO employerDTO;
    private int numberOfEmployees;
    private boolean optionalHomeOffice;

    public DepartmentDTO() {
    }

    public DepartmentDTO(Department department){
        this.id = department.getId();
        this.departmentName = department.getDepartmentName();
        this.employerDTO = new EmployerDTO(department.getEmployer());
        this.numberOfEmployees = department.getNumberOfEmployees();
        this.optionalHomeOffice = department.isOptionalHomeOffice();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(DepartmentName departmentName) {
        this.departmentName = departmentName;
    }

    public EmployerDTO getEmployerDTO() {
        return employerDTO;
    }

    public void setEmployerDTO(EmployerDTO employerDTO) {
        this.employerDTO = employerDTO;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public boolean isOptionalHomeOffice() {
        return optionalHomeOffice;
    }

    public void setOptionalHomeOffice(boolean optionalHomeOffice) {
        this.optionalHomeOffice = optionalHomeOffice;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "id=" + id +
                ", departmentName=" + departmentName +
                ", employerDTO=" + employerDTO +
                ", numberOfEmployees=" + numberOfEmployees +
                ", optionalHomeOffice=" + optionalHomeOffice +
                '}';
    }
}
