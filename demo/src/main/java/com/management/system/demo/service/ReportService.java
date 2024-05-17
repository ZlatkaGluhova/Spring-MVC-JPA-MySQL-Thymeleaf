package com.management.system.demo.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import org.springframework.http.HttpEntity;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface ReportService {

    StringBuilder getReportByUserId(Long id);

    void getPdfReportByUserId(Long id) throws IOException, DocumentException, URISyntaxException;

    HttpEntity<byte[]> generatePdfReportByUserId(Long id) throws DocumentException, IOException, URISyntaxException;

    String createPdfReportByUserId(Long id);
}
