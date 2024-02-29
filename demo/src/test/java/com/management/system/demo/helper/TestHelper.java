package com.management.system.demo.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.management.system.demo.dto.DepartmentDTO;
import com.management.system.demo.dto.request.UserCreateDTORequest;
import com.management.system.demo.dto.response.UserCreateDTOResponse;
import com.management.system.demo.enums.Country;
import com.management.system.demo.enums.DepartmentName;
import com.management.system.demo.enums.Status;
import com.management.system.demo.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static Employer createEmployer(Long id) {
        Employer employer = new Employer();
        employer.setId(id);
        employer.setFirstName("Pesho");
        employer.setLastName("Ivanov");
        employer.setCountry(Country.BULGARIA);
        employer.setSalary(BigDecimal.valueOf(9000));
        employer.setCreatedOn(LocalDateTime.now());

        return employer;
    }

    public static Employer createEmployer(Long id, LocalDateTime createdOn) {
        Employer employer = createEmployer(id);
        employer.setCreatedOn(createdOn);

        return employer;
    }

    public static UserCreateDTORequest createUser() {
        UserCreateDTORequest user = new UserCreateDTORequest();
        user.setUsername("vasi_853");
        user.setPassword("Vasi853*");
        user.setEmail("vasi@abv.bg");
        user.setBirthDate(LocalDate.of(2000, 8,15));

        return user;
    }

    public static String asJsonString(final Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Employer> createEmployerList() {
        List<Employer> employers = new ArrayList<>();
        employers.add(TestHelper.createEmployer(1L));
        employers.add(TestHelper.createEmployer(2L));
        employers.add(TestHelper.createEmployer(3L));

        return employers;
    }

    public static Employee createEmployee(Long id) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFirstName("Andrey");
        employee.setLastName("Petrov");
        employee.setEmail("andrey@abv.bg");
        employee.setAge(28);
        employee.setDepartment(new Department(DepartmentName.IT, 5, true));
        employee.setSalary(BigDecimal.valueOf(5000));
        employee.setCreatedOn(LocalDateTime.now());
        employee.setStatus(Status.ACTIVE);

        return employee;
    }

    public static List<Employee> createEmployeeList() {
        List<Employee> employee = new ArrayList<>();
        employee.add(TestHelper.createEmployee(1L));
        employee.add(TestHelper.createEmployee(2L));
        employee.add(TestHelper.createEmployee(3L));

        return employee;
    }

    public static DepartmentDTO createDepartmentDTO(Long id, DepartmentName departmentName) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(id);
        departmentDTO.setDepartmentName(departmentName);
        departmentDTO.setNumberOfEmployees(5);
        departmentDTO.setOptionalHomeOffice(true);

        return departmentDTO;
    }

    public static Department createDepartment(Long id, DepartmentName departmentName) {
        Department department = new Department();
        department.setId(id);
        department.setDepartmentName(departmentName);
        department.setNumberOfEmployees(7);
        department.setOptionalHomeOffice(true);

        return department;
    }

    public static List<DepartmentDTO> createDepartmentDTOList() {
        List<DepartmentDTO> departmentDTOS = new ArrayList<>();
        departmentDTOS.add(TestHelper.createDepartmentDTO(1L, DepartmentName.IT));
        departmentDTOS.add(TestHelper.createDepartmentDTO(2L, DepartmentName.HR));
        departmentDTOS.add(TestHelper.createDepartmentDTO(3L, DepartmentName.FINANCE));

        return departmentDTOS;
    }

    public static List<Department> createDepartmentList() {
        List<Department> departments = new ArrayList<>();
        departments.add(TestHelper.createDepartment(1L, DepartmentName.IT));
        departments.add(TestHelper.createDepartment(2L, DepartmentName.HR));
        departments.add(TestHelper.createDepartment(3L, DepartmentName.FINANCE));

        return departments;
    }



}
