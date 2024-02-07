package com.management.system.demo.service;

import com.management.system.demo.dto.request.UserCreateDTORequest;
import com.management.system.demo.dto.response.UserCreateDTOResponse;
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

        User user = mappedDataFromUserDTORequestToUserDB(userCreateDTORequest);
        user.setCreatedOn(LocalDateTime.now());
        User userDB = userRepository.save(user);
        UserCreateDTOResponse userCreateDTOResponse = mappedDataFromUserDBToUserDTOResponce(userDB);
        return userCreateDTOResponse;
    }


    private User mappedDataFromUserDTORequestToUserDB(UserCreateDTORequest userCreateDTORequest){
        User userFromDB = new User();
        userFromDB.setUsername(userCreateDTORequest.getUsername());
        userFromDB.setPassword(userCreateDTORequest.getPassword());
        userFromDB.setRoles(userCreateDTORequest.getRoles());

        return userFromDB;
    }

    private UserCreateDTOResponse mappedDataFromUserDBToUserDTOResponce(User user) {
        UserCreateDTOResponse userCreateDTOResponse = new UserCreateDTOResponse();
        userCreateDTOResponse.setId(user.getId());
        userCreateDTOResponse.setUsername(user.getUsername());
        userCreateDTOResponse.setPassword(user.getPassword());
        userCreateDTOResponse.setCreatedOn(user.getCreatedOn());
        userCreateDTOResponse.setRoles(user.getRoles());

        return userCreateDTOResponse;
    }


    // for update
    private User mappedDataFromUserToUserDB(User user) {
        User userFromDB = userRepository.findById(user.getId()).orElseThrow(() -> new RuntimeException("User not found for id : " + user.getId()));

        userFromDB.setUsername(user.getUsername());
        userFromDB.setPassword(user.getPassword());
        //roles
        userFromDB.setUpdatedOn(LocalDateTime.now());

        return userFromDB;
    }
}
