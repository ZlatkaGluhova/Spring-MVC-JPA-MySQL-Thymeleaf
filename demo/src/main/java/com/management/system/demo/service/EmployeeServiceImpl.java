package com.management.system.demo.service;

import com.management.system.demo.dto.EmployeeDTO;
import com.management.system.demo.enums.Status;
import com.management.system.demo.model.Employee;
import com.management.system.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found for id : " + id));

        return employee;
    }

    @Override
    public void deleteEmployeeById(long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public void changeEmployeeStatus(long id, Status status) {
        Employee employee = getEmployeeById(id);
        employee.setStatus(status);
        saveEmployee(employee);
    }

    @Override
    public Employee getEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public List<Employee> getEmails(String email) {
//        return employeeRepository.findByEmailContaining("abv");

        List<Employee> findByEmailContaining = employeeRepository.findByEmailContaining(email);
        System.out.println("findByEmailContaining = " + findByEmailContaining);
        return findByEmailContaining;
    }

    @Override
    public List<Employee> getStatus(Status status) {
        List<Employee> findByStatus = employeeRepository.findByStatus(status);
        System.out.println("findByEmailContaining = " + findByStatus);
        return findByStatus;
    }

    @Override
    public List<Employee> findByAgeBetween(int startAge, int endAge) {
        List<Employee> findByAgeBetweenStartAgeAndEndAge = employeeRepository.findByAgeBetween(startAge, endAge);
        return findByAgeBetweenStartAgeAndEndAge;
    }

    @Override
    public List<Employee> findAllExistingEmployees() {
        List<Employee> allExistingEmployees = employeeRepository.findByStatusNot(Status.DELETED);
        return allExistingEmployees;
    }
}
