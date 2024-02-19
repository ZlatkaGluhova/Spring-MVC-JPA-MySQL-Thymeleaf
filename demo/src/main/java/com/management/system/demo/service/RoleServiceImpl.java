package com.management.system.demo.service;

import com.management.system.demo.dto.request.RoleCreateDTORequest;
import com.management.system.demo.dto.request.RoleUpdateDTORequest;
import com.management.system.demo.dto.response.RoleCreateDTOResponse;
import com.management.system.demo.dto.response.RoleUpdateDTOResponse;
import com.management.system.demo.enums.RoleType;
import com.management.system.demo.model.Role;
import com.management.system.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleCreateDTOResponse saveRole(RoleCreateDTORequest roleCreateDTORequest) {
        Role role = mappedDataFromRoleCreateDTORequestToRoleDB(roleCreateDTORequest);
        Role roleDB = roleRepository.save(role);
        RoleCreateDTOResponse roleCreateDTOResponse = mappedDataFromRoleDBToRoleCreateDTOResponse(roleDB);

        return roleCreateDTOResponse;
    }

    private RoleCreateDTOResponse mappedDataFromRoleDBToRoleCreateDTOResponse(Role roleDB) {
        RoleCreateDTOResponse roleCreateDTOResponse = new RoleCreateDTOResponse();
        roleCreateDTOResponse.setId(roleDB.getId());
        roleCreateDTOResponse.setType(roleDB.getType());
        roleCreateDTOResponse.setDescription(roleDB.getDescription());
        roleCreateDTOResponse.setUsers(roleDB.getUsers());

        return roleCreateDTOResponse;
    }


    private Role mappedDataFromRoleCreateDTORequestToRoleDB(RoleCreateDTORequest roleCreateDTORequest) {
        Role roleFromDB = new Role();
        roleFromDB.setType(roleCreateDTORequest.getType());
        roleFromDB.setDescription(roleCreateDTORequest.getDescription());
        roleFromDB.setUsers(roleCreateDTORequest.getUsers());

        return roleFromDB;
    }

    //TODO fix handle exception
    @Override
    public Role getRoleById(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not exist with id: " + id));

        return role;
    }

    @Override
    public RoleUpdateDTOResponse updateRole(Long id, RoleUpdateDTORequest roleUpdateDTORequest) {
        roleUpdateDTORequest.setId(id);
        Role roleFromDB = getRoleById(id);
        Role updateRole = new Role(roleFromDB, roleUpdateDTORequest);

        Role updateRoleDB = roleRepository.save(updateRole);
        RoleUpdateDTOResponse roleUpdateDTOResponse = new RoleUpdateDTOResponse(updateRoleDB);

        return roleUpdateDTOResponse;
    }

    @Override
    public void deleteRole(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not exist with id: " + id));

        roleRepository.delete(role);
    }
}
