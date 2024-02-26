package com.management.system.demo.model;

import com.management.system.demo.dto.request.UserUpdateDTORequest;
import com.management.system.demo.service.validations.ValidPassword;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    @NotNull
    @Size(min = 3, max = 15)
//    @Pattern(regexp = "^[a-zA-Z0-9]{3,15}$",
//            message = "username must be of 6 to 12 length with no special characters")
    private String username;

    @Column(name = "password")
    @NotNull
    @Size(min = 8, max = 12)
//    @Pattern(regexp = "^((?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$&*])(?=.*[0-9])){8,12}$",
//            message = "Password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit ")
//    @Pattern(regexp="^(?=.*[0-9])(?=.*[A-Z])$")
    @ValidPassword
    private String password;

    @Column(name = "created_on")
    private LocalDateTime createdOn;

    @Column(name = "updated_on")
    private LocalDateTime updatedOn;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;

    public User() {
    }

    public User(String username, String password, LocalDateTime createdOn, List<Role> roles) {
        this.username = username;
        this.password = password;
        this.createdOn = createdOn;
        this.roles = roles;
    }

    public User(User userFromDB, UserUpdateDTORequest userUpdateDTORequest) {
        this.setId(userUpdateDTORequest.getId() != null ? userFromDB.getId() : userUpdateDTORequest.getId());
        this.setUsername(userUpdateDTORequest.getUsername());
        this.setPassword(userUpdateDTORequest.getPassword());
        this.setCreatedOn(userFromDB.getCreatedOn());
        this.setUpdatedOn(LocalDateTime.now());
        this.setRoles(userUpdateDTORequest.getRoles());
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

    public LocalDateTime getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String toStringU() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", roles=" + roles +
                '}';
    }
}
