package com.management.system.demo.dto.request;

import com.management.system.demo.enums.RoleType;
import com.management.system.demo.model.User;

import java.util.List;
import java.util.Objects;

public class RoleCreateDTORequest {

    private RoleType type;
    private String description;
    private List<User> users;

    public RoleCreateDTORequest() {
    }

    public RoleCreateDTORequest(RoleType type, String description) {
        this.type = type;
        this.description = description;
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
        RoleCreateDTORequest that = (RoleCreateDTORequest) o;
        return type == that.type &&
                Objects.equals(description, that.description) &&
                Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, description, users);
    }

    @Override
    public String toString() {
        return "RoleCreateDTORequest{" +
                "type=" + type +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
