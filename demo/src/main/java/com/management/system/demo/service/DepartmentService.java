package com.management.system.demo.service;

import com.management.system.demo.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();

    void saveDepartment(Department department);

    Department getDepartmentById(Long id);
}
