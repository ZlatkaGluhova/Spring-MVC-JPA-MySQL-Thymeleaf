package com.management.system.demo.model;


import com.management.system.demo.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
//    @NotNull(message = "First name shouldn't be null!")
//    @NotBlank
//    @Size(min = 2, max = 50)
    private String firstName;

    @Column(name = "last_name")
//    @NotNull(message = "First name shouldn't be null!")
//    @NotBlank
//    @Size(min = 2, max = 50)
    private String lastName;

    @Column(name = "email")
//    @Email(message = "Invalid email address")
    private String email;

    @Column(name = "age")
//    @NotBlank(message = "Age should not be empty or null")
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 70, message = "Age should not be more than 70")
    private int age;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "salary")
//    @NotNull(message = "Salary shouldn't be null!")
    private BigDecimal salary;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    //    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = Status.ACTIVE;


    public Employee() {
    }

//    public Employee(String firstName, String lastName, String email, int age, BigDecimal salary, LocalDateTime createdOn, Status status) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.age = age;
//        this.salary = salary;
//        this.createdOn = createdOn;
//        this.status = status;
//    }

    public Employee(String firstName, String lastName, String email, int age, Department department, BigDecimal salary, LocalDateTime createdOn, Status status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.createdOn = createdOn;
        this.status = status;
    }

    public Employee(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", department=" + department +
                ", salary=" + salary +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", status=" + status +
                '}';
    }
}
