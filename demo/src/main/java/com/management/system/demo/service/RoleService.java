package com.management.system.demo.service;

import com.management.system.demo.dto.request.RoleCreateDTORequest;
import com.management.system.demo.dto.request.RoleUpdateDTORequest;
import com.management.system.demo.dto.response.RoleCreateDTOResponse;
import com.management.system.demo.dto.response.RoleUpdateDTOResponse;
import com.management.system.demo.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    RoleCreateDTOResponse saveRole(RoleCreateDTORequest roleCreateDTORequest);

    Role getRoleById(Long id);

    RoleUpdateDTOResponse updateRole(Long id, RoleUpdateDTORequest roleUpdateDTORequest);

    void deleteRole(Long id);
}
