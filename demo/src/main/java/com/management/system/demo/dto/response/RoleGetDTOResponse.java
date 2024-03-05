package com.management.system.demo.dto.response;

import com.management.system.demo.enums.RoleType;
import com.management.system.demo.model.Role;
import com.management.system.demo.model.User;

import java.util.List;

public class RoleGetDTOResponse extends RoleUpdateDTOResponse {

    public RoleGetDTOResponse() {
    }

    public RoleGetDTOResponse(Long id, RoleType type, String description, List<User> users) {
        super(id, type, description, users);
    }

    public RoleGetDTOResponse(Role updateRoleDB) {
        super(updateRoleDB);
    }

    public RoleGetDTOResponse(Role role, List<User> users) {
        this.id = role.getId();
        this.type = role.getType();
        this.description = role.getDescription();
        this.users = users;
    }

    @Override
    public String toString() {
        return "RoleGetDTOResponse{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
