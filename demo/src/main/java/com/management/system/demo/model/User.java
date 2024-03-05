package com.management.system.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.management.system.demo.dto.request.UserUpdateDTORequest;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private Integer age;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "isActive")
    private Boolean isActive = true;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public User() {
    }

    public User(String username, String password, LocalDateTime createdOn, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.createdOn = createdOn;
        this.roles = roles;
    }

    public User(Long id, String username, String password, LocalDateTime createdOn, LocalDateTime updatedOn, String email, Integer age, Boolean isActive, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.email = email;
        this.age = age;
        this.isActive = isActive;
        this.roles = roles;
    }

    public User(User userFromDB, UserUpdateDTORequest userUpdateDTORequest) {
        this.setId(userUpdateDTORequest.getId() != null ? userFromDB.getId() : userUpdateDTORequest.getId());
        this.setUsername(userUpdateDTORequest.getUsername());
        this.setPassword(userUpdateDTORequest.getPassword());
        this.setEmail(userUpdateDTORequest.getEmail());
        this.setAge(userUpdateDTORequest.getAge());
        this.setActive(userUpdateDTORequest.isActive());
        this.setCreatedOn(userFromDB.getCreatedOn());
        this.setUpdatedOn(LocalDateTime.now());
        this.setRoles(userUpdateDTORequest.getRoles());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }


    public Boolean isActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String toStringU() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                ", roles=" + roles +
                '}';
    }
}
