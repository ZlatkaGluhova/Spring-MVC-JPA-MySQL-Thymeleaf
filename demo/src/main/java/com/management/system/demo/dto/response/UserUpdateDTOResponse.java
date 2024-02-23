package com.management.system.demo.dto.response;

import com.management.system.demo.dto.request.UserUpdateDTORequest;
import com.management.system.demo.model.Role;
import com.management.system.demo.model.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class UserUpdateDTOResponse extends UserUpdateDTORequest {

    private LocalDateTime updatedOn;

    public UserUpdateDTOResponse() {
    }

    public UserUpdateDTOResponse(Long id, String username, String password, LocalDateTime createdOn, List<Role> roles, LocalDateTime updatedOn) {
        super(id, username, password, createdOn, roles);
        this.updatedOn = updatedOn;
    }

    public UserUpdateDTOResponse(User updateUserDB) {
        this.id = updateUserDB.getId(); // 1. nai-dobre
        username = updateUserDB.getUsername(); // 2.
        this.setPassword(updateUserDB.getPassword()); // 3.
        this.setCreatedOn(updateUserDB.getCreatedOn());
        this.setUpdatedOn(updateUserDB.getUpdatedOn());
        setRoles(updateUserDB.getRoles()); // 4.
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
        UserUpdateDTOResponse that = (UserUpdateDTOResponse) o;
        return Objects.equals(updatedOn, that.updatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(updatedOn);
    }

    @Override
    public String toString() {
        return "UserUpdateDTOResponse{" +
                "updatedOn=" + updatedOn +
                ", id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdOn=" + createdOn +
                ", roles=" + roles +
                '}';
    }
}
