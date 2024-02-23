package com.management.system.demo.controller;

import com.management.system.demo.dto.request.RoleCreateDTORequest;
import com.management.system.demo.dto.request.RoleUpdateDTORequest;
import com.management.system.demo.dto.response.RoleCreateDTOResponse;
import com.management.system.demo.dto.response.RoleGetDTOResponse;
import com.management.system.demo.dto.response.RoleUpdateDTOResponse;
import com.management.system.demo.model.Role;
import com.management.system.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    //build create Role REST API
    @PostMapping
    public RoleCreateDTOResponse createRole(@RequestBody RoleCreateDTORequest roleCreateDTORequest) {
        RoleCreateDTOResponse roleCreateDTOResponse = roleService.saveRole(roleCreateDTORequest);

        return roleCreateDTOResponse;
    }

    //build get Role by id REST API
    @GetMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);

        return ResponseEntity.ok(role);
    }

    //build update Role by id REST API
    @PutMapping("/{id}")
    public ResponseEntity<RoleUpdateDTOResponse> updateRole(@PathVariable Long id, @RequestBody RoleUpdateDTORequest roleUpdateDTORequest) {
        RoleUpdateDTOResponse updateRole = roleService.updateRole(id, roleUpdateDTORequest);

        return ResponseEntity.ok(updateRole);
    }

    //build delete Role by id REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);

        return ResponseEntity.ok("The Role with id: " + id + " is deleted successfully");
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<RoleGetDTOResponse> getRoleByIdWithUsers(@PathVariable Long id) {
        RoleGetDTOResponse role = roleService.getRoleByIdWithUsers(id);

        return ResponseEntity.ok(role);
    }

}
