package com.management.system.demo.controller;


import com.management.system.demo.constants.Constant;
import com.management.system.demo.dto.DepartmentDTO;
import com.management.system.demo.enums.ConstantType;
import com.management.system.demo.model.Department;
import com.management.system.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public String showDepartments(Model model) {
        List<DepartmentDTO> departmentsDTO = departmentService.getAllDepartments();
        model.addAttribute("listDepartments", departmentsDTO);

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
    public String saveDepartment(@ModelAttribute("department") Department department) {
        //save employee to db
        departmentService.saveDepartment(department);
        return ConstantType.DEPARTMENT.getRedirectType();
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = Constant.ID) Long id, Model model) {
        //get the model from the service
        Department department = departmentService.getDepartmentById(id);
        //set employee as a model attribute to pre-populate the form
        model.addAttribute(ConstantType.DEPARTMENT.getType(), department);
        return ConstantType.DEPARTMENT.getUpdateType();
    }


}
