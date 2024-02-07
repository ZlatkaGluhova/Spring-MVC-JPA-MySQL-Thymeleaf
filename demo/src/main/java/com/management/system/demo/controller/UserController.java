package com.management.system.demo.controller;


import com.management.system.demo.dto.request.UserCreateDTORequest;
import com.management.system.demo.dto.response.UserCreateDTOResponse;
import com.management.system.demo.model.User;
import com.management.system.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //build create User REST API
    @PostMapping
    public UserCreateDTOResponse createUser(@RequestBody UserCreateDTORequest userCreateDTORequest) {
        UserCreateDTOResponse userCreateDTOResponse = userService.saveUser(userCreateDTORequest);
        return userCreateDTOResponse;
    }
}
