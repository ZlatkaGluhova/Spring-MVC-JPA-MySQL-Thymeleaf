package com.management.system.demo.repository;

import com.management.system.demo.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    List<Employer> findAll();

    Employer findByDepartment_id(Long departmentId);

}
