package com.management.system.demo.service.validations;

import com.management.system.demo.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeValidationService {


    public String validateEmployee(Employee employee) {
        String message = "";

        message = validateAge(employee, message);

        return message;
    }

    private String validateAge(Employee employee, String message) {

        if (employee.getAge() < 18 || employee.getAge() > 70) {
            message = "Age is invalid for " + employee.getAge();
        }

        return message;
    }
}

