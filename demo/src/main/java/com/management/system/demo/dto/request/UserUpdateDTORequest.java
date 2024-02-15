package com.management.system.demo.dto.request;

import com.management.system.demo.model.Role;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class UserUpdateDTORequest {

    protected Long id;
    protected String username;
    protected String password;
    protected LocalDateTime createdOn;
    protected List<Role> roles;

    public UserUpdateDTORequest() {
    }


    public UserUpdateDTORequest(Long id, String username, String password, LocalDateTime createdOn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdOn = createdOn;
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
