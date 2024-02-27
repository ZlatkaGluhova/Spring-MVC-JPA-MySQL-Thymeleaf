package com.management.system.demo.controller;

import com.management.system.demo.dto.request.UserCreateDTORequest;
import com.management.system.demo.dto.request.UserUpdateDTORequest;
import com.management.system.demo.dto.response.UserCreateDTOResponse;
import com.management.system.demo.dto.response.UserUpdateDTOResponse;
import com.management.system.demo.model.User;
import com.management.system.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public UserCreateDTOResponse createUser(
            @Valid @RequestBody UserCreateDTORequest userCreateDTORequest) {
        UserCreateDTOResponse userCreateDTOResponse = userService.saveUser(userCreateDTORequest);

        return userCreateDTOResponse;
    }

    //build get User by id REST API
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    //build update User by id REST API
    @PutMapping("/{id}")
    public ResponseEntity<UserUpdateDTOResponse> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserUpdateDTORequest userUpdateDTORequest) {
        UserUpdateDTOResponse updateUser = userService.updateUser(id, userUpdateDTORequest);

        return ResponseEntity.ok(updateUser);
    }

    //build delete User by id REST API
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);

        return ResponseEntity.ok("The User with id: " + id + " is deleted successfully");
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Object>  handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
////        ex.getBindingResult().getAllErrors()
////        AtomicReference<ExceptionResponse> exceptionResponse = null;
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
////            exceptionResponse.set(new ExceptionResponse(new Date(), fieldName, errorMessage));
//        });
//        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), errors.toString(), "");
//
//        return new ResponseEntity(errors, HttpStatus.NOT_FOUND);
//    }
}
