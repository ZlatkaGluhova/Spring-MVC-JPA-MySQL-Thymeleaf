package com.management.system.demo.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.management.system.demo.model.Role;
import com.management.system.demo.model.User;
import com.management.system.demo.utils.FileOutput;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


@Service
public class ReportServiceImpl implements ReportService {

    public static final List<String> headers = new ArrayList<>(Arrays.asList("ID", "USERNAME", "PASSWORD", "CREATED_ON", "UPDATED_ON", "EMAIL", "AGE", "IS_ACTIVE", "ROLE"));

    @Autowired
    private UserService userService;

//    @Autowired
//    private ReportService reportService;


    @Override
    public StringBuilder getReportByUserId(Long id) {
        User user = userService.getUserById(id);

//        String mappedUserToString = FileOutput.mappedUserToString(user, i);

        List<Role> userRoles = user.getRoles();
        List<String> usersToString = new ArrayList<>();

        for (int i = 0; i < userRoles.size(); i++) {
            String userToString = FileOutput.mappedUserToString(user, i);
            usersToString.add(userToString);
        }

        String header = FileOutput.createHeader(headers);
//        FileOutput.writeInCSVFile(mappedUserToString, header);

//        return FileOutput.writeInCSVFile(mappedUserToString, header);

        List<String> reportUser = FileOutput.writeInCSVFile(usersToString, header);

        StringBuilder stringBuilder = new StringBuilder();
        for (String report : reportUser) {
            stringBuilder.append(report);
            stringBuilder.append(System.getProperty("line.separator"));
        }
//        return FileOutput.writeInCSVFile(usersToString, header);
        return stringBuilder;

    }

    @Override
    public void getPdfReportByUserId(Long id) throws DocumentException, IOException, URISyntaxException {
        generatePdfReportByUser(id);

//        FileOutputStream outputStream = new FileOutputStream(pdfFile);

    }

    private String generatePdfReportByUser(Long id) throws IOException, DocumentException, URISyntaxException {

        User user = userService.getUserById(id);
        List<Role> userRoles = user.getRoles();
        List<String> usersToString = new ArrayList<>();

        for (int i = 0; i < userRoles.size(); i++) {
            String userToString = FileOutput.mappedUserToString(user, i);
            usersToString.add(userToString);
        }


        String pdfReportName = "pdfReport.pdf";
        String directoryPathName = String.valueOf(Paths.get(Paths.get("").toRealPath().toString()));

        //Create folder in which you want to save Pdf documents
        File directory = FileOutput.createDirectory(directoryPathName, "PDF-Reports");
// daily-pdf-user(imeto na usera)-report_10-04-2024.pdf

        //Create pdf file
        File pdfFile = FileOutput.createFile(directory, pdfReportName);

        String header = FileOutput.createHeader(headers);
        Document reportUser = FileOutput.writeInPDFFile(usersToString, header, pdfFile);

        return pdfFile.getAbsolutePath();
    }

    @Override
    public HttpEntity<byte[]> generatePdfReportByUserId(Long id) throws DocumentException, IOException, URISyntaxException {

        File pdfFile = null;
        try {
//            User user = userService.getUserById(id);
            String pdfFileName = generatePdfReportByUser(id);
            pdfFile = new File(pdfFileName);

            return getHttpEntity(pdfFile);
        } catch (Exception e) {
            System.out.println("PDF File does not created!");
            throw e;
        } finally {
            //Pdf documents should be deleted
            if (pdfFile != null && pdfFile.exists()) {
                boolean is_deleted = pdfFile.delete();
                System.out.println("File is deleted successfully! - " + is_deleted);
            } else {
                System.out.println("PDF File does not exist!");
            }
        }
    }

//        }

//        private HttpEntity<byte[]> generateInvoicePdf(String financialDocumentId) throws ResourceNotFoundException, IOException {
//            File pdfFile = null;
//            try {
//                FinancialDocumentDTO financialDocument = invoicePDFService.getFinancialDocumentById(financialDocumentId);
//                String pdfFileName = invoicePDFService.generateFinancialDocumentPDF(financialDocument);
//                pdfFile = new File(pdfFileName);
//
//                return getHttpEntity(pdfFile);
//            } catch (Exception e) {
//                logger.warn("PDF File does not created!", e);
//                throw e;
//            } finally {
//                //Pdf documents should be deleted
//                if (pdfFile != null && pdfFile.exists()) {
//                    pdfFile.delete();
//                } else {
//                    logger.warn("PDF File does not exist!");
//                }
//            }
//        }


    @Override
    public String createPdfReportByUserId(Long id) {


        return null;
    }

    private HttpEntity<byte[]> getHttpEntity(File file) throws IOException {
        byte[] byteArray = new byte[0];
        if (file.exists()) {
            byteArray = IOUtils.toByteArray(new FileInputStream(file));
        }
        HttpHeaders header = new HttpHeaders();
        header.setContentType(new MediaType("text", "pdf", StandardCharsets.UTF_8));
        header.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + file.getName().replaceAll(" ", "-"));
        header.setContentLength(byteArray.length);

        return new HttpEntity<>(byteArray, header);
    }

}
