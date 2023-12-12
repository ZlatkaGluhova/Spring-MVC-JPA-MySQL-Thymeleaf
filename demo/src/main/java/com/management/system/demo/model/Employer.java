package com.management.system.demo.model;

import com.management.system.demo.enums.Country;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Table(name = "employers")
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    @NotNull
    @Size(min = 2, max = 50)
    private String firstName;

    @Column(name = "last_name")
    @NotNull
    @Size(min = 2, max = 50)
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    @NotNull
    private Country country;

    @Column(name = "salary")
    @NotNull
    private BigDecimal salary;

    //dep
    @OneToOne
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;


    public Employer() {
    }

    public Employer(String firstName, String lastName, Country country, BigDecimal salary, LocalDateTime createdOn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.salary = salary;
        this.createdOn = createdOn;
    }

    public Employer(String firstName, String lastName, Country country, BigDecimal salary, Department department, LocalDateTime createdOn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.salary = salary;
        this.department = department;
        this.createdOn = createdOn;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer employer = (Employer) o;
        return Objects.equals(id, employer.id) &&
                Objects.equals(firstName, employer.firstName) &&
                Objects.equals(lastName, employer.lastName) &&
                country == employer.country &&
                Objects.equals(salary, employer.salary) &&
                Objects.equals(department, employer.department) &&
                Objects.equals(createdOn, employer.createdOn) &&
                Objects.equals(updatedOn, employer.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, country, salary, department, createdOn, updatedOn);
    }

    @Override
    public String toString() {
        return "Employer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country=" + country +
                ", salary=" + salary +
                ", department=" + department +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
