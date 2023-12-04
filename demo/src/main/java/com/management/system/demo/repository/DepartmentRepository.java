package com.management.system.demo.repository;

import com.management.system.demo.enums.DepartmentName;
import com.management.system.demo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAll();

    Optional<Department> findByDepartmentName(DepartmentName departmentName);
}
