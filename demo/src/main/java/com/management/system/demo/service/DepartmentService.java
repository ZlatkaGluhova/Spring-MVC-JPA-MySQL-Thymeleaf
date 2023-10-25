package com.management.system.demo.service;

import com.management.system.demo.model.Department;
import com.management.system.demo.model.Employer;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();

    void saveDepartment(Department department);
}
