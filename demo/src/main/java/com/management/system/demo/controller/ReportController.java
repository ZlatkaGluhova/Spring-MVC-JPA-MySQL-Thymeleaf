package com.management.system.demo.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.management.system.demo.model.User;
import com.management.system.demo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping("/csv/{id}")
    public StringBuilder getReportByUserId(@PathVariable Long id) {
        return reportService.getReportByUserId(id);

//        return ResponseEntity.ok(user);
    }

    @GetMapping("/pdf/{id}")
    public void getPdfReportByUserId(@PathVariable Long id) throws DocumentException, IOException, URISyntaxException {
//        return reportService.getPdfReportByUserId(id);
        reportService.getPdfReportByUserId(id);
//        return ResponseEntity.ok(user);
    }

    @GetMapping("/generate-pdf/{id}")
    public HttpEntity<byte[]> generatePdfReportByUserId(@PathVariable Long id) throws DocumentException, IOException, URISyntaxException {
//        return reportService.getPdfReportByUserId(id);

        return reportService.generatePdfReportByUserId(id);
    }
}
