package com.management.system.demo.service;

import com.management.system.demo.dto.DepartmentDTO;
import com.management.system.demo.dto.EmployerDTO;
import com.management.system.demo.model.Department;
import com.management.system.demo.model.Employer;
import com.management.system.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        List<DepartmentDTO> departmentsDTO = getDepartmentDTOS(departments);

        return departmentsDTO;
    }

    private List<DepartmentDTO> getDepartmentDTOS(List<Department> departments) {
        List<DepartmentDTO> departmentsDTO = new ArrayList<>();

        for (Department department : departments) {
            DepartmentDTO departmentDTO = new DepartmentDTO(department);
            departmentsDTO.add(departmentDTO);
        }

        return departmentsDTO;
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
