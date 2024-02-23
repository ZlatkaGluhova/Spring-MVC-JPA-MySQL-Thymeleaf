package com.management.system.demo.dto.request;

import com.management.system.demo.model.Role;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserUpdateDTORequest {

    protected Long id;
    protected String username;
    protected String password;
    protected String email;
    protected int age;
    protected boolean isActive = true;
    protected LocalDateTime createdOn;
    protected List<Role> roles;

    public UserUpdateDTORequest() {
    }


    public UserUpdateDTORequest(Long id, String username, String password, LocalDateTime createdOn, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdOn = createdOn;
        this.roles = roles;
    }

    public UserUpdateDTORequest(Long id, String username, String password, String email, int age, boolean isActive, LocalDateTime createdOn, List<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.isActive = isActive;
        this.createdOn = createdOn;
        this.roles = roles;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserUpdateDTORequest that = (UserUpdateDTORequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(createdOn, that.createdOn) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, createdOn, roles);
    }

    @Override
    public String toString() {
        return "UserUpdateDTORequest{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdOn=" + createdOn +
                ", roles=" + roles +
                '}';
    }
}
