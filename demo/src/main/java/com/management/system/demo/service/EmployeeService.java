package com.management.system.demo.service;

import com.management.system.demo.enums.Status;
import com.management.system.demo.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployeeById(Long id);

    void deleteEmployeeById(Long id);

    void changeEmployeeStatus(Long id, Status status);

    Employee getEmail(String email);

    List<Employee> getEmails(String email);

    List<Employee> getStatus(Status filter);

    List<Employee> findByAgeBetween(int startAge, int endAge);

    List<Employee> findAllExistingEmployees();
}
