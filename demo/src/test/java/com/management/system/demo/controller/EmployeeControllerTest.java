package com.management.system.demo.controller;

import com.management.system.demo.enums.ConstantType;
import com.management.system.demo.enums.Status;
import com.management.system.demo.helper.TestHelper;
import com.management.system.demo.model.Employee;
import com.management.system.demo.model.Employer;
import com.management.system.demo.service.DepartmentService;
import com.management.system.demo.service.EmployeeService;
import com.management.system.demo.service.EmployerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class EmployeeControllerTest {

    @MockBean
    private EmployerService employerService;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private DepartmentService departmentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testShowEmployees_Success() throws Exception {

        List<Employee> employees = TestHelper.createEmployeeList();

        when(employeeService.findAllExistingEmployees()).thenReturn(employees);

        String url = "/employee";
        ResultActions result = mockMvc.perform(get(url)
                .flashAttr("listEmployees", employees));
        result.andExpect(status().isOk());
        result.andExpect(view().name(ConstantType.EMPLOYEE.getListType()));
        result.andExpect(model().attributeExists("listEmployees"));

        verify(employeeService).findAllExistingEmployees();
    }

    @Test
    void testShowNewEmployeeForm_Success() throws Exception {
        Employee employee = new Employee();


        String url = "/employee/showNewEmployeeForm";
        ResultActions result = mockMvc.perform(get(url)
                .flashAttr(ConstantType.EMPLOYEE.getType(), employee));
        result.andExpect(status().isOk());
        result.andExpect(view().name(ConstantType.EMPLOYEE.getNewType()));
        result.andExpect(model().attributeExists(ConstantType.EMPLOYEE.getType()));


    }

    @Test
    void testSaveEmployee_Success() throws Exception {

        //arrange
        Employee employee = TestHelper.createEmployee(null);

        doNothing().when(employeeService).saveEmployee(employee);

        String url = "/employee/saveEmployee";
        ResultActions result = mockMvc.perform(post(url)
                .flashAttr("employee", employee));
        result.andExpect(status().is3xxRedirection());
        result.andExpect(view().name(ConstantType.EMPLOYEE.getRedirectType()));

        verify(employeeService).saveEmployee(employee);

    }

    @Test
    void testShowFormForUpdate_Success() throws Exception {
        Long id = 1L;
        Employee employee = TestHelper.createEmployee(id);

        when(employeeService.getEmployeeById(id)).thenReturn(employee);


        String url = "/employee/showFormForUpdate/{id}";
        ResultActions result = mockMvc.perform(get(url, id)
                .flashAttr(ConstantType.EMPLOYEE.getType(), employee));
        result.andExpect(status().isOk());
        result.andExpect(view().name(ConstantType.EMPLOYEE.getUpdateType()));
        result.andExpect(model().attributeExists(ConstantType.EMPLOYEE.getType()));

        verify(employeeService).getEmployeeById(id);

    }

    @Test
    void testDeleteEmployee_Success() throws Exception {
        Long id = 1L;
        Employee employee = TestHelper.createEmployee(id);

        doNothing().when(employeeService).deleteEmployeeById(id);


        String url = "/employee/deleteEmployee/{id}";
        ResultActions result = mockMvc.perform(get(url, id)
                .flashAttr(ConstantType.EMPLOYEE.getType(), employee));
        result.andExpect(status().is3xxRedirection());
        result.andExpect(view().name(ConstantType.EMPLOYEE.getRedirectType()));
//        result.andExpect(model().attributeExists(ConstantType.EMPLOYEE.getType()));

        verify(employeeService).deleteEmployeeById(id);


    }

    @Test
    void testChangeEmployeeStatus_Success() throws Exception {
        Long id = 1L;
        Status status = Status.INACTIVE;

        Employee employee = TestHelper.createEmployee(id);

        doNothing().when(employeeService).changeEmployeeStatus(id, status);
//        when(employeeService.changeEmployeeStatus(id, status)).thenCallRealMethod();
//        doCallRealMethod().when(employeeService).changeEmployeeStatus(id, status);
//        when(employeeService.changeEmployeeStatus(id, status)).thenCallRealMethod();


        String url = "/employee/changeEmployeeStatus/{status}/{id}";
        ResultActions result = mockMvc.perform(get(url, status, id)
                .flashAttr(ConstantType.EMPLOYEE.getType(), employee));

        result.andExpect(status().is3xxRedirection());
        result.andExpect(view().name(ConstantType.EMPLOYEE.getRedirectType()));

        verify(employeeService).changeEmployeeStatus(id, status);

    }
}