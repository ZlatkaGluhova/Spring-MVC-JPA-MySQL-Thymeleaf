package com.management.system.demo.service;

import com.management.system.demo.model.Department;
import com.management.system.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found for id : " + id));

        return department;
    }
}
