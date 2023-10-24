package com.management.system.demo.controller;

import com.management.system.demo.service.HomePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController {

//    @Autowired
//    private HomePageService homePageService;

    @GetMapping
    public String showHomePage(){

        return "home";
    }
}
