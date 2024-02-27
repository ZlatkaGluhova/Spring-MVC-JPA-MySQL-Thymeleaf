package com.management.system.demo.dto.response;

import com.management.system.demo.dto.request.UserCreateDTORequest;
import com.management.system.demo.model.Role;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class UserCreateDTOResponse extends UserCreateDTORequest {

    private Long id;
    private LocalDateTime createdOn;

    public UserCreateDTOResponse() {
    }

//    public UserCreateDTOResponse(String username, String password, List<Role> roles, Long id, LocalDateTime createdOn) {
//        super(username, password, roles);
//        this.id = id;
//        this.createdOn = createdOn;
//    }
//
//    public UserCreateDTOResponse(String username, String password, String email, Integer age, Boolean isActive, List<Role> roles, Long id, LocalDateTime createdOn) {
//        super(username, password, email, age, isActive, roles);
//        this.id = id;
//        this.createdOn = createdOn;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserCreateDTOResponse that = (UserCreateDTOResponse) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createdOn, that.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, createdOn);
    }

    @Override
    public String toString() {
        return "UserCreateDTOResponse{" +
                "id=" + id +
                ", createdOn=" + createdOn +
                '}';
    }
}
