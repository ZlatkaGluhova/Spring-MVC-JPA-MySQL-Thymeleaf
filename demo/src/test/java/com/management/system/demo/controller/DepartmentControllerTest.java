package com.management.system.demo.controller;

import com.management.system.demo.dto.DepartmentDTO;
import com.management.system.demo.enums.ConstantType;
import com.management.system.demo.enums.DepartmentName;
import com.management.system.demo.helper.TestHelper;
import com.management.system.demo.model.Department;
import com.management.system.demo.model.Employee;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class DepartmentControllerTest {

    @MockBean
    private EmployerService employerService;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private DepartmentService departmentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testShowDepartments_Success() throws Exception {

        List<DepartmentDTO> departmentsDTO = TestHelper.createDepartmentDTOList();

        when(departmentService.getAllDepartments()).thenReturn(departmentsDTO);

        String url = "/department";
        ResultActions result = mockMvc.perform(get(url)
                .flashAttr("listDepartments", departmentsDTO));
        result.andExpect(status().isOk());
        result.andExpect(view().name(ConstantType.DEPARTMENT.getListType()));
        result.andExpect(model().attributeExists("listDepartments"));

        verify(departmentService).getAllDepartments();

    }

    @Test
    void testShowNewDepartmentForm_Success() throws Exception {
        Department department = new Department();


        String url = "/department/showNewDepartmentForm";
        ResultActions result = mockMvc.perform(get(url)
                .flashAttr(ConstantType.DEPARTMENT.getType(), department));
        result.andExpect(status().isOk());
        result.andExpect(view().name(ConstantType.DEPARTMENT.getNewType()));
        result.andExpect(model().attributeExists(ConstantType.DEPARTMENT.getType()));

    }

    @Test
    void testSaveDepartment_Success() throws Exception {
        Department department = TestHelper.createDepartment(1L, DepartmentName.FINANCE);

        doNothing().when(departmentService).saveDepartment(department);

        String url = "/department/saveDepartment";
        ResultActions result = mockMvc.perform(post(url)
                .flashAttr("department", department));
        result.andExpect(status().is3xxRedirection());
        result.andExpect(view().name(ConstantType.DEPARTMENT.getRedirectType()));

        verify(departmentService).saveDepartment(department);

    }

    @Test
    void testShowFormForUpdate_Success() throws Exception {
        Long id = 1L;
        Department department = TestHelper.createDepartment(1L, DepartmentName.FINANCE);


        when(departmentService.getDepartmentById(id)).thenReturn(department);


        String url = "/department/showFormForUpdate/{id}";
        ResultActions result = mockMvc.perform(get(url, id)
                .flashAttr(ConstantType.DEPARTMENT.getType(), department));
        result.andExpect(status().isOk());
        result.andExpect(view().name(ConstantType.DEPARTMENT.getUpdateType()));
        result.andExpect(model().attributeExists(ConstantType.DEPARTMENT.getType()));

        verify(departmentService).getDepartmentById(id);

    }
}