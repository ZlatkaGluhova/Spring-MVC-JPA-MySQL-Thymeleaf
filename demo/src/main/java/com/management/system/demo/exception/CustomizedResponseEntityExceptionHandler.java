package com.management.system.demo.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

    @ExceptionHandler({NoHandlerFoundException.class})
    public ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex, HttpServletRequest httpServletRequest) throws JsonProcessingException {
        Map<String, String> errors = new HashMap<>();
        errors.put("message", "Resource not found");
        Map<String, Object> error = new HashMap<>();
        error.put("code", HttpStatus.NOT_FOUND.value());
        error.put("message", errors);
        ObjectMapper objectMapper = new ObjectMapper();
        String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(error);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(prettyJson);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(
            UserNotFoundException ex, HttpServletRequest httpServletRequest) throws JsonProcessingException {

        String prettyJson = exceptionText(ex);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(prettyJson);
    }

    public String exceptionText(Throwable ex) throws JsonProcessingException {
        Map<String, Object> errors = new HashMap<>();
        errors.put("code", HttpStatus.NOT_FOUND.value());
        errors.put("message", ex.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errors);

        return prettyJson;
    }


    @ExceptionHandler({InvalidAgeException.class})
    public ResponseEntity<Object> handleInvalidAgeException(
            InvalidAgeException ex, HttpServletRequest httpServletRequest) throws JsonProcessingException {

        String prettyJson = exceptionText(ex);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(prettyJson);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(
            MethodArgumentNotValidException ex) throws JsonProcessingException {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        Map<String, Object> error = new HashMap<>();
        error.put("code", HttpStatus.NOT_FOUND.value());
        error.put("message", errors);
        ObjectMapper objectMapper = new ObjectMapper();
        String prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(error);
//        String prettyJson = exceptionText(ex);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON).body(prettyJson);
    }
}
