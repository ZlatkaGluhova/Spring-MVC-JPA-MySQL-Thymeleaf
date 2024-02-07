package com.management.system.demo.service;

import com.management.system.demo.dto.request.UserCreateDTORequest;
import com.management.system.demo.dto.response.UserCreateDTOResponse;
import com.management.system.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    UserCreateDTOResponse saveUser(UserCreateDTORequest userCreateDTORequest);
}
