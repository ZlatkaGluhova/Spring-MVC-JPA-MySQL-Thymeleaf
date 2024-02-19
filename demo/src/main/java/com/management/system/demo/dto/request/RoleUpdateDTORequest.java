package com.management.system.demo.dto.request;

import com.management.system.demo.enums.RoleType;
import com.management.system.demo.model.User;

import java.util.List;
import java.util.Objects;

public class RoleUpdateDTORequest {

    protected Long id;
    protected RoleType type;
    protected String description;
    protected List<User> users;

    public RoleUpdateDTORequest() {
    }

    public RoleUpdateDTORequest(Long id, RoleType type, String description, List<User> users) {
        this.id = id;
        this.type = type;
        this.description = description;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getType() {
        return type;
    }

    public void setType(RoleType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleUpdateDTORequest that = (RoleUpdateDTORequest) o;
        return Objects.equals(id, that.id) &&
                type == that.type &&
                Objects.equals(description, that.description) &&
                Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, description, users);
    }

    @Override
    public String toString() {
        return "RoleUpdateDTORequest{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
