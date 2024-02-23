package com.management.system.demo.dto.response;

import com.management.system.demo.dto.request.RoleUpdateDTORequest;
import com.management.system.demo.enums.RoleType;
import com.management.system.demo.model.Role;
import com.management.system.demo.model.User;

import java.util.List;
import java.util.Set;

public class RoleUpdateDTOResponse extends RoleUpdateDTORequest {

    public RoleUpdateDTOResponse() {
    }

    public RoleUpdateDTOResponse(Long id, RoleType type, String description, List<User> users) {
        super(id, type, description, users);
    }

    public RoleUpdateDTOResponse(Role updateRoleDB) {
        this.id = updateRoleDB.getId();
        this.setType(updateRoleDB.getType());
        this.setDescription(updateRoleDB.getDescription());
        this.setUsers(updateRoleDB.getUsers());
    }

    @Override
    public String toString() {
        return "RoleUpdateDTOResponse{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
