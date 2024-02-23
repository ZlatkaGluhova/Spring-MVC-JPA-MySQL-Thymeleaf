package com.management.system.demo.service;

import com.management.system.demo.dto.request.RoleCreateDTORequest;
import com.management.system.demo.dto.request.RoleUpdateDTORequest;
import com.management.system.demo.dto.response.RoleCreateDTOResponse;
import com.management.system.demo.dto.response.RoleGetDTOResponse;
import com.management.system.demo.dto.response.RoleUpdateDTOResponse;
import com.management.system.demo.model.Role;
import com.management.system.demo.model.User;
import com.management.system.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    @Lazy
    private RoleRepository roleRepository;

    @Autowired
    @Lazy
    private UserService userService;

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
    public RoleGetDTOResponse getRoleByIdWithUsers(Long id) {
        Role role = roleRepository.findById(id).orElseThrow(() -> new RuntimeException("Role not exist with id: " + id));
        List<User> users = userService.getAllUsersWithRoles(List.of(role));

        RoleGetDTOResponse roleGetDTOResponse = new RoleGetDTOResponse(role, users);

        return roleGetDTOResponse;
    }

    private Role mappedDataFromRoleGetDTORequestToRoleDB(RoleGetDTOResponse roleGetDTOResponse) {
        Role roleFromDB = new Role();
        roleFromDB.setId(roleGetDTOResponse.getId());
        roleFromDB.setType(roleGetDTOResponse.getType());
        roleFromDB.setDescription(roleGetDTOResponse.getDescription());
        roleFromDB.setUsers(roleGetDTOResponse.getUsers());

        return roleFromDB;
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
