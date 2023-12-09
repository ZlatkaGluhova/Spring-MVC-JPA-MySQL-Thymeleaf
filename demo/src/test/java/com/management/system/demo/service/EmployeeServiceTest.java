package com.management.system.demo.service;

import com.management.system.demo.helper.TestHelper;
import com.management.system.demo.model.Employee;
import com.management.system.demo.model.Employer;
import com.management.system.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testGetAllEmployees_Success() {
        employeeService.getAllEmployees();
    }

    @Test
    public void testSaveEmployeeWithId_Success() {
        Employee employee = TestHelper.createEmployee(1L);

        employeeService.saveEmployee(employee);
    }

    @Test
    public void testSaveEmployeeWithoutId_Success() {
//        Employee employee = TestHelper.createEmployee(null);
//
//        employeeService.saveEmployee(employee);
    }

    @Test
    public void testGetEmployeeById_Success() {
    }

    @Test
    public void testDeleteEmployeeById_Success() {
    }

    @Test
    public void testChangeEmployeeStatus_Success() {
    }
}