package com.management.system.demo.model;

import com.management.system.demo.enums.DepartmentName;

import javax.persistence.*;


@Entity
@Table(name = "department")
public class Department {
    // employers

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name")
    private DepartmentName departmentName;

//    //employer
//    @OneToOne(mappedBy = "department")
//    private Employer employer;

    @Column(name = "numbers_of_employees")
    private int numberOfEmployees;

    @Column(name = "optional_home_office")
    private boolean optionalHomeOffice;

    public Department() {
    }

    public Department(DepartmentName departmentName, int numberOfEmployees, boolean optionalHomeOffice) {
        this.departmentName = departmentName;
        this.numberOfEmployees = numberOfEmployees;
        this.optionalHomeOffice = optionalHomeOffice;
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

//    public Employer getEmployer() {
//        return employer;
//    }
//
//    public void setEmployer(Employer employer) {
//        this.employer = employer;
//    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName=" + departmentName +
                ", numberOfEmployees=" + numberOfEmployees +
                ", optionalHomeOffice=" + optionalHomeOffice +
                '}';
    }
}
