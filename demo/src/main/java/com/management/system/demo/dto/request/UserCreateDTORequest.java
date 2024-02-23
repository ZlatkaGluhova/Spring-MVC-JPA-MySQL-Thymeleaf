package com.management.system.demo.dto.request;

import com.management.system.demo.model.Role;

import javax.persistence.Column;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserCreateDTORequest {

    private String username;
    private String password;
    private String email;
    private int age;
    private boolean isActive;
    private List<Role> roles;

    public UserCreateDTORequest() {
    }

    public UserCreateDTORequest(String username, String password, String email, int age) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
    }

    public UserCreateDTORequest(String username, String password, String email, int age, boolean isActive, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.age = age;
        this.isActive = isActive;
        this.roles = roles;
    }

    public UserCreateDTORequest(String username, String password, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
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
        UserCreateDTORequest that = (UserCreateDTORequest) o;
        return age == that.age &&
                isActive == that.isActive &&
                Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
                Objects.equals(email, that.email) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, roles);
    }

    @Override
    public String toString() {
        return "UserCreateDTORequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", isActive=" + isActive +
                ", roles=" + roles +
                '}';
    }
}

