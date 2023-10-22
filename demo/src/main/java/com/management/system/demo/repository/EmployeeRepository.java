package com.management.system.demo.repository;

import com.management.system.demo.enums.Status;
import com.management.system.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {


    Employee findByEmail(String email);
//    List<Employee> findAllByEmailAndFirstNameAndLastNameIsNull(String email);

    List<Employee> findByEmailContaining(String filter);

    List<Employee> findByStatus(Status status);

    List<Employee> findByAgeBetween(int startAge, int endAge);

    List<Employee> findByStatusNot(Status statusDTO);
}

