package com.management.system.demo.model;


import com.management.system.demo.dto.request.RoleUpdateDTORequest;
import com.management.system.demo.enums.RoleType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "roles")
public class Role {
    //id
    //type
    //description
    //list of users

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private RoleType type;

    @Column(name = "description")
    private String description;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

    public Role() {
    }

    public Role(Role roleFromDB, RoleUpdateDTORequest roleUpdateDTORequest) {
        this.setId(roleUpdateDTORequest.getId() != null ? roleFromDB.getId() : roleUpdateDTORequest.getId());
        this.setType(roleUpdateDTORequest.getType());
        this.setDescription(roleUpdateDTORequest.getDescription());
        this.setUsers(roleUpdateDTORequest.getUsers());
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
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", type=" + type +
                ", description='" + description + '\'' +
                ", users=" + users +
                '}';
    }
}
