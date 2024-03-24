package com.management.system.demo.controller;

import com.management.system.demo.model.User;
import com.management.system.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/{id}")
    public StringBuilder getReportByUserId(@PathVariable Long id) {
        return reportService.getReportByUserId(id);

//        return ResponseEntity.ok(user);
    }
}
