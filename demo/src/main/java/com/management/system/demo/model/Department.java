package com.management.system.demo.model;

import com.management.system.demo.enums.DepartmentName;

import javax.persistence.*;


@Entity
@Table(name = "department")
public class Department {
    // name - enum, employees number, shte ima i shefove, optionalHomeOffice(bool)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DepartmentName name;

    @Column(name = "numbers_of_employees")
    private int numberOfEmployees;

    @Column(name = "optional_home_office")
    private boolean optionalHomeOffice;

    public Department() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentName getName() {
        return name;
    }

    public void setName(DepartmentName name) {
        this.name = name;
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
        return "Department{" +
                "id=" + id +
                ", name=" + name +
                ", numberOfEmployees=" + numberOfEmployees +
                ", optionalHomeOffice=" + optionalHomeOffice +
                '}';
    }
}
