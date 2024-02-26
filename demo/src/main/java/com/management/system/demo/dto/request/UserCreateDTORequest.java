package com.management.system.demo.dto.request;

import com.management.system.demo.model.Role;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

public class UserCreateDTORequest {

    @NotNull
    @Size(min = 3, max = 15)
//    @Pattern(regexp = "^[a-zA-Z0-9]{3,15}$",
//            message = "username must be of 6 to 12 length with no special characters")
    private String username;

    @NotNull
//    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){8,12}$",
//            message = "Password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
    //    @Size(min = 8, max = 12)
    @Pattern(regexp="^(?=.*[0-9])(?=.*[A-Z])$")
//    @ValidPassword
    private String password;


    private List<Role> roles;

    public UserCreateDTORequest() {
    }

    public UserCreateDTORequest(String username, String password) {
        this.username = username;
        this.password = password;
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
        return Objects.equals(username, that.username) &&
                Objects.equals(password, that.password) &&
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
                ", roles=" + roles +
                '}';
    }
}

