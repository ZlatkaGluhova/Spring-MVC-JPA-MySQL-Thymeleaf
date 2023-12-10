package com.management.system.demo.service;

import com.management.system.demo.dto.DepartmentDTO;
import com.management.system.demo.enums.DepartmentName;
import com.management.system.demo.helper.TestHelper;
import com.management.system.demo.model.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private EmployerService employerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;


    @Test
    void testGetAllDepartments_Success() {

        departmentService.getAllDepartments();
    }

    @Test
    void testSaveDepartment_Success() {
        Department department = TestHelper.createDepartment(1L, DepartmentName.HR);

        departmentService.saveDepartment(department);
    }

    @Test
    void testGetDepartmentById_Success() {
        Department department = TestHelper.createDepartment(1L, DepartmentName.FINANCE);
        departmentService.getDepartmentById(department.getId());
    }

    @Test
    void testGetDepartmentByDepartmentName_Success() {
        Department department = TestHelper.createDepartment(2L, DepartmentName.FINANCE);
        departmentService.getDepartmentByDepartmentName(department.getDepartmentName());
    }
}