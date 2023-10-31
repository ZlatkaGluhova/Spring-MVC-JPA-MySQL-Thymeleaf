package com.management.system.demo.controller;

import com.management.system.demo.dto.AgeDTO;
import com.management.system.demo.model.Employee;
import com.management.system.demo.dto.FinancialDocumentDTO;
import com.management.system.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestController {

    int i = 1;
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/home")
    public List<Employee> home(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("count", i++);
        return employees;
    }

    @GetMapping("/f")
    public FinancialDocumentDTO financialDocument() {
        FinancialDocumentDTO financialDocumentDTO = createFinancialDocument();

        Employee employee = financialDocumentDTO.getEmployee();
        employee.setId(5l);

        System.out.println(financialDocumentDTO);
        return financialDocumentDTO;
    }

    private FinancialDocumentDTO createFinancialDocument() {
        FinancialDocumentDTO financialDocumentDTO = new FinancialDocumentDTO();
        financialDocumentDTO.setId(1l);
        financialDocumentDTO.setEmployee(new Employee(2l));

        return financialDocumentDTO;
    }

    @GetMapping("/email/{email}")
    public Employee email(@PathVariable(value = "email") String email) {
        Employee employee = employeeService.getEmail(email);
        return employee;
    }

    @GetMapping("/email/contains/{filter}")
    public List<Employee> filter(@PathVariable(value = "filter") String filter) {

        List<Employee> employees = employeeService.getEmails(filter);
        return employees;
    }

    //POST
    @PostMapping("/status")
    public List<Employee> status(@RequestBody Employee employee) {

        List<Employee> employees = employeeService.getStatus(employee.getStatus());
        return employees;
    }


    //TODO get by id
    @GetMapping("/{id}")
    public Employee getById(@PathVariable(value = "id") long id) {
        Employee employeeById = employeeService.getEmployeeById(id);
        return employeeById;
    }


    //TODO create
    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }


    //TODO update
    @PutMapping("/update/{id}")
    public Employee update(@PathVariable(value = "id") long id,
                           @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.saveEmployee(employee);
        return employee;
    }


    //TODO delete
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(value = "id") long id) {
        employeeService.deleteEmployeeById(id);
    }


    //TODO *find age between 20 and 50 years employee
//    @GetMapping("/age")
//    public List<Employee> getByAgeBetweenStartAgeAndEndAge(@RequestParam int startAge,
//                                                           @RequestParam int endAge) {
//        List<Employee> employeesByAge = employeeService.findByAgeBetweenStartAgeAndEndAge(startAge, endAge);
//        return employeesByAge;
//    }

    @PostMapping("/ageBetween")
    public List<Employee> getByAgeBetweenStartAgeAndEndAge(@RequestBody AgeDTO ageDTO) {
        List<Employee> employeesByAge = employeeService.findByAgeBetween(ageDTO.getStartAge(), ageDTO.getEndAge());
        return employeesByAge;
    }

    @PostMapping("/allEmployees")
    public List<Employee> findAllExistingEmployees() {
        List<Employee> employees = employeeService.findAllExistingEmployees();
        return employees;
    }
}
