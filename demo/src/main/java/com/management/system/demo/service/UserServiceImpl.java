package com.management.system.demo.service;

import com.management.system.demo.dto.request.UserCreateDTORequest;
import com.management.system.demo.dto.request.UserUpdateDTORequest;
import com.management.system.demo.dto.response.UserCreateDTOResponse;
import com.management.system.demo.dto.response.UserUpdateDTOResponse;
import com.management.system.demo.exception.UserNotFoundException;
import com.management.system.demo.model.User;
import com.management.system.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserCreateDTOResponse saveUser(UserCreateDTORequest userCreateDTORequest) {

        User user = mappedDataFromUserCreateDTORequestToUserDB(userCreateDTORequest);
        User userDB = userRepository.save(user);
        UserCreateDTOResponse userCreateDTOResponse = mappedDataFromUserDBToUserCreateDTOResponse(userDB);

        return userCreateDTOResponse;
    }

    //TODO fix handle exception
    @Override
    public User getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not exist with id: " + id));

        return user;
    }

    @Override
    public UserUpdateDTOResponse updateUser(Long id, UserUpdateDTORequest userUpdateDTORequest) {

        userUpdateDTORequest.setId(id);
        User userFromDB = getUserById(id);
        User updateUser = new User(userFromDB, userUpdateDTORequest);

        User updateUserDB = userRepository.save(updateUser);
        UserUpdateDTOResponse userUpdateDTOResponse = new UserUpdateDTOResponse(updateUserDB);

        return userUpdateDTOResponse;
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not exist with id: " + id));

        userRepository.delete(user);
    }


    private UserCreateDTOResponse mappedDataFromUserDBToUserCreateDTOResponse(User user) {
        UserCreateDTOResponse userCreateDTOResponse = new UserCreateDTOResponse();
        userCreateDTOResponse.setId(user.getId());
        userCreateDTOResponse.setUsername(user.getUsername());
        userCreateDTOResponse.setPassword(user.getPassword());
        userCreateDTOResponse.setCreatedOn(user.getCreatedOn());
        userCreateDTOResponse.setRoles(user.getRoles());

        return userCreateDTOResponse;
    }

    private User mappedDataFromUserCreateDTORequestToUserDB(UserCreateDTORequest userCreateDTORequest) {
        User userFromDB = new User();
        userFromDB.setUsername(userCreateDTORequest.getUsername());
        userFromDB.setPassword(userCreateDTORequest.getPassword());
        userFromDB.setCreatedOn(LocalDateTime.now());
        userFromDB.setRoles(userCreateDTORequest.getRoles());

        return userFromDB;
    }
}
