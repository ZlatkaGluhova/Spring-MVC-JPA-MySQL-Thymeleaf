package com.management.system.demo.controller;


import com.management.system.demo.constants.Constant;
import com.management.system.demo.enums.ConstantType;
import com.management.system.demo.model.Employer;
import com.management.system.demo.service.EmployerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employer")
public class EmployerController {

    @Autowired
    private EmployerService employerService;

    @GetMapping
    public String showEmployers(Model model) {
        List<Employer> employers = employerService.getAllEmployers();
        model.addAttribute("listEmployers", employers);

        return ConstantType.EMPLOYER.getListType();
    }

    @GetMapping("/showNewEmployerForm")
    public String showNewEmployerForm(Model model) {
        // create model attribute to bind form data
        Employer employer = new Employer();
        model.addAttribute(ConstantType.EMPLOYER.getType(), employer); // k - v

        return ConstantType.EMPLOYER.getNewType();
    }

    @PostMapping("/saveEmployer")
    public String saveEmployer(@ModelAttribute("employer") Employer employer) {
        //save employee to db
        employerService.saveEmployer(employer);

        return ConstantType.EMPLOYER.getRedirectType();
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = Constant.ID) Long id, Model model) {
        //get the model from the service
        Employer employer = employerService.getEmployerById(id);
        //set employee as a model attribute to pre-populate the form
        model.addAttribute(ConstantType.EMPLOYER.getType(), employer);
        return ConstantType.EMPLOYER.getUpdateType();
    }

}
