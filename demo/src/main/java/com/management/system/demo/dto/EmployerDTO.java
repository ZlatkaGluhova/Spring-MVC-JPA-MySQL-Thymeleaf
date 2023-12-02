package com.management.system.demo.dto;

import com.management.system.demo.model.Employer;


public class EmployerDTO extends Employer {

    private String fullName;

    public EmployerDTO() {
    }

    public EmployerDTO(Employer employer){
        super(employer.getFirstName(), employer.getLastName(), employer.getCountry(), employer.getSalary(), employer.getDepartment(), employer.getCreatedOn());
        this.fullName = employer.getFirstName() + " " + employer.getLastName();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void createFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    }
}
