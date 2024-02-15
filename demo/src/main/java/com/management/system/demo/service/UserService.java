package com.management.system.demo.service;

import com.management.system.demo.dto.request.UserCreateDTORequest;
import com.management.system.demo.dto.request.UserUpdateDTORequest;
import com.management.system.demo.dto.response.UserCreateDTOResponse;
import com.management.system.demo.dto.response.UserUpdateDTOResponse;
import com.management.system.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    UserCreateDTOResponse saveUser(UserCreateDTORequest userCreateDTORequest);

    User getUserById(Long id);

    UserUpdateDTOResponse updateUser(Long id, UserUpdateDTORequest userUpdateDTORequest);

    void deleteUser(Long id);
}
