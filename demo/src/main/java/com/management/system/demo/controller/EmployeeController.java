package com.management.system.demo.controller;


import com.management.system.demo.constants.Constant;
import com.management.system.demo.enums.ConstantType;
import com.management.system.demo.enums.Status;
import com.management.system.demo.model.Employee;
import com.management.system.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //display list of employees
    @GetMapping
    public String showEmployees(Model model) {
        List<Employee> employees = employeeService.findAllExistingEmployees();
        model.addAttribute("listEmployees", employees);

        return ConstantType.EMPLOYEE.getListType();
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute(ConstantType.EMPLOYEE.getType(), employee); // k - v

        return ConstantType.EMPLOYEE.getNewType();
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        //save employee to db
        employeeService.saveEmployee(employee);

        return ConstantType.EMPLOYEE.getRedirectType();
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = Constant.ID) long id, Model model) {
        //get the model from the service
        Employee employee = employeeService.getEmployeeById(id);
        //set employee as a model attribute to pre-populate the form
        model.addAttribute(ConstantType.EMPLOYEE.getType(), employee);

        return ConstantType.EMPLOYEE.getUpdateType();
    }


    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(value = Constant.ID) long id, Model model) {
        //call delete employee method
        this.employeeService.deleteEmployeeById(id);

        return ConstantType.EMPLOYEE.getRedirectType();
    }

    @GetMapping("/changeEmployeeStatus/{status}/{id}")
    public String changeEmployeeStatus(@PathVariable(value = Constant.ID) long id,
                                       @PathVariable(value = Constant.STATUS) Status status,
                                       Model model) {
//        System.out.println("changeEmployeeStatus");
        this.employeeService.changeEmployeeStatus(id, status);

        return ConstantType.EMPLOYEE.getRedirectType();
    }

}
