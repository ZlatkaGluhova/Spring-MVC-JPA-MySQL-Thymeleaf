package com.management.system.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.management.system.demo.model.Role;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

//@Validated
//@JsonPropertyOrder({ "createdOn"})
@JsonPropertyOrder({"username", "password", "email", "age", "birthDate", "createdOn", "isActive", "roles"})
public class UserUpdateDTORequest extends UserCreateDTORequest{

//    @JsonIgnore
    protected Long id;
    protected LocalDateTime createdOn;

    public UserUpdateDTORequest() {
    }

    public UserUpdateDTORequest(Long id, String username, String password, String email, int age, boolean isActive, LocalDateTime createdOn, List<Role> roles) {
        super(username, password, email, age, isActive, roles);
        this.id = id;
        this.createdOn = createdOn;
    }

    public UserUpdateDTORequest(Long id, String username, String password, LocalDateTime createdOn, List<Role> roles) {
        super(username, password, roles);
        this.id = id;
        this.createdOn = createdOn;
    }

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

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserUpdateDTORequest that = (UserUpdateDTORequest) o;
//        return Objects.equals(id, that.id) &&
//                Objects.equals(username, that.username) &&
//                Objects.equals(password, that.password) &&
//                Objects.equals(createdOn, that.createdOn) &&
//                Objects.equals(roles, that.roles);
//    }


//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, username, password, createdOn, roles);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserUpdateDTORequest that = (UserUpdateDTORequest) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(createdOn, that.createdOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, createdOn);
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
