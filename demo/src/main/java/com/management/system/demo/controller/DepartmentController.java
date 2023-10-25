package com.management.system.demo.controller;


import com.management.system.demo.enums.ConstantType;
import com.management.system.demo.model.Department;
import com.management.system.demo.model.Employer;
import com.management.system.demo.service.DepartmentService;
import com.management.system.demo.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String showEmployers(Model model) {
        List<Department> departments = departmentService.getAllDepartments();
        model.addAttribute("listDepartments", departments);

        return ConstantType.DEPARTMENT.getListType();
    }

    @GetMapping("/showNewDepartmentForm")
    public String showNewDepartmentForm(Model model) {
        // create model attribute to bind form data
        Department department = new Department();
        model.addAttribute(ConstantType.DEPARTMENT.getType(), department); // k - v

        return ConstantType.DEPARTMENT.getNewType();
    }

    @PostMapping("/saveDepartment")
    public String saveEmployer(@ModelAttribute("department") Department department) {
        //save employee to db
        departmentService.saveDepartment(department);

        return ConstantType.DEPARTMENT.getRedirectType();
    }


}
