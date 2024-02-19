package com.management.system.demo.dto.response;

import com.management.system.demo.dto.request.RoleCreateDTORequest;
import com.management.system.demo.enums.RoleType;

import java.util.Objects;

public class RoleCreateDTOResponse extends RoleCreateDTORequest {

    private Long id;

    public RoleCreateDTOResponse() {
    }

    public RoleCreateDTOResponse(RoleType type, String description, Long id) {
        super(type, description);
        this.id = id;
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
