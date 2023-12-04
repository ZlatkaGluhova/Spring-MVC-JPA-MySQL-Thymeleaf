package com.management.system.demo.service;

import com.management.system.demo.dto.DepartmentDTO;
import com.management.system.demo.enums.DepartmentName;
import com.management.system.demo.enums.Status;
import com.management.system.demo.model.Department;
import com.management.system.demo.model.Employee;
import com.management.system.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentService departmentService;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        if (employee.getId() != null) {
            employee = mappedDataFromEmployeeToEmployeeDB(employee);
        } else {
            employee.setCreatedOn(LocalDateTime.now());
        }

        this.employeeRepository.save(employee);
    }

    private Employee mappedDataFromEmployeeToEmployeeDB(Employee employee) {
        Employee employeeFromDB = employeeRepository.findById(employee.getId()).orElseThrow(() -> new RuntimeException("Employee not found for id : " + employee.getId()));

        employeeFromDB.setFirstName(employee.getFirstName());
        employeeFromDB.setLastName(employee.getLastName());
        employeeFromDB.setEmail(employee.getEmail());
        employeeFromDB.setAge(employee.getAge());

        DepartmentName departmentName = employee.getDepartment().getDepartmentName();
        Department department = departmentService.getDepartmentByDepartmentName(departmentName);
        employeeFromDB.setDepartment(department);

        employeeFromDB.setSalary(employee.getSalary());
        employeeFromDB.setUpdatedOn(LocalDateTime.now());
        employeeFromDB.setStatus(employee.getStatus());

        return employeeFromDB;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found for id : " + id));

        return employee;
    }

    @Override
    public void deleteEmployeeById(Long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public void changeEmployeeStatus(Long id, Status status) {
        Employee employee = getEmployeeById(id);
        employee.setStatus(status);
        employee.setUpdatedOn(LocalDateTime.now());
        saveEmployee(employee);
    }

    @Override
    public Employee getEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public List<Employee> getEmails(String email) {
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
