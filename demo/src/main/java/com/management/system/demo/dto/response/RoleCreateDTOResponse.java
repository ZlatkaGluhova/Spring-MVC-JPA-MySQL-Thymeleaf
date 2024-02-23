package com.management.system.demo.dto.response;

import com.management.system.demo.dto.request.RoleCreateDTORequest;
import com.management.system.demo.enums.RoleType;
import com.management.system.demo.model.User;

import javax.mail.search.SearchTerm;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class RoleCreateDTOResponse extends RoleCreateDTORequest {

    private Long id;
    private List<User> users;

    public RoleCreateDTOResponse() {
    }

    public RoleCreateDTOResponse(RoleType type, String description, Long id) {
        super(type, description);
        this.id = id;
    }

    public RoleCreateDTOResponse(RoleType type, String description, Long id, List<User> users) {
        super(type, description);
        this.id = id;
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RoleCreateDTOResponse that = (RoleCreateDTOResponse) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "RoleCreateDTOResponse{" +
                "id=" + id +
                '}';
    }
}
