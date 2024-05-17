package com.management.system.demo.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.management.system.demo.model.Role;
import com.management.system.demo.model.User;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class FileOutput {

    public static final String CSV_SEPARATOR = ";";

    private static final String pathName = "D:\\Zlatka_Gluhova\\IT\\Projects\\user.csv";

    public static String createHeader(List<String> headers) {
        StringBuilder sb = new StringBuilder();
        for (String header : headers) {
            sb.append(header).append(CSV_SEPARATOR);
        }

        return sb.toString();
    }

    //private
    public static String mappedUserToString(User user, int i) {

        if (user.getUsername() == null) {
            throw new IllegalArgumentException("USERNAME cannot be empty!");
        }

        if (user.getCreatedOn() == null) {
            throw new IllegalArgumentException("CREATED_ON cannot be empty!");
        }

        String separator = FileOutput.CSV_SEPARATOR;
        StringBuilder sb = new StringBuilder();
        sb.append(user.getId())
                .append(separator)
                .append(user.getUsername())
                .append(separator)
                .append(user.getPassword())
                .append(separator)
                .append(user.getCreatedOn())
                .append(separator)
                .append(user.getUpdatedOn() != null ? user.getUpdatedOn() : "")
                .append(separator)
                .append(user.getEmail() != null ? user.getEmail() : "")
                .append(separator)
                .append(user.getAge() != null ? user.getAge() : "")
                .append(separator)
                .append(user.isActive() != null ? user.isActive() : "")
                .append(separator)
                .append(user.getRoles() != null ? user.getRoles().get(i).getType().getName() : "")
                .append(separator);

        return sb.toString();
    }

    public static List<String> writeInCSVFile(List<String> mappedDataToString, String header) {
        File file = new File(pathName);
        boolean exist = fileIsExist(pathName);

        try {
            BufferedWriter csvWriter;
            if (exist) {
                FileWriter fr = new FileWriter(file, true);
                csvWriter = new BufferedWriter(fr);
            } else {
                csvWriter = new BufferedWriter(new FileWriter(file));
                csvWriter.write(header);
                csvWriter.newLine();
            }

            if (mappedDataToString != null) {
//                csvWriter.newLine();
                for (String data : mappedDataToString) {
                    csvWriter.write(data);
                    csvWriter.newLine();
                }

                csvWriter.flush();
                csvWriter.close();
            }

        } catch (IOException ex) {
            System.out.printf("Cannot write file: %s, ", file.getName() + ex);
        }
        List<String> reportData = new ArrayList<>();
        reportData.add(header);
        for (String data : mappedDataToString) {
            reportData.add(data);
        }

//        return mappedDataToString;
        return reportData;
    }

    public static boolean fileIsExist(String fileName) {
        File file = new File(fileName);
        boolean exist = file.exists();
        return exist;
    }

    public static String getPathName() {
        return pathName;
    }

//    public static void setPathName(String name) {
//        pathName = name;
//    }

    public static void printData(String element, Map<String, String> data) {
        data.entrySet()
                .forEach(entry -> System.out.printf(element + " with %s: %s is not found!%n", entry.getKey(), entry.getValue()));
    }

    public static Document writeInPDFFile(List<String> usersToString, String headers, File pdfFile) throws DocumentException, IOException, URISyntaxException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(pdfFile));

        document.open();

        PdfPTable table = new PdfPTable(9);
        addTableHeader(table, headers);
        addRows(table, usersToString);
//        addCustomRows(table);

        document.add(table);
        document.close();

        return document;
    }

//    public StringBuilder pdfReport(Long id) {
//        User user = userService.getUserById(id);
//
//        List<Role> userRoles = user.getRoles();
//        List<String> usersToString = new ArrayList<>();
//
//        for (int i = 0; i < userRoles.size(); i++) {
//            String userToString = FileOutput.mappedUserToString(user, i);
//            usersToString.add(userToString);
//        }
//
//        String header = FileOutput.createHeader(headers);
//
//        List<String> reportUser = FileOutput.writeInCSVFile(usersToString, header);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        for (String report : reportUser) {
//            stringBuilder.append(report);
//            stringBuilder.append(System.getProperty("line.separator"));
//        }
//        return stringBuilder;
//    }

//    public void metod() throws DocumentException, IOException, URISyntaxException {
//        Document document = new Document();
//        PdfWriter.getInstance(document, new FileOutputStream("iTextTable.pdf"));
//
//        document.open();
//
//        PdfPTable table = new PdfPTable(9);
//        addTableHeader(table);
//        addRows(table);
////        addCustomRows(table);
//
//        document.add(table);
//        document.close();
//    }

    private static void addTableHeader(PdfPTable table, String headers) {
        Stream.of(headers.split(";"))
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    private static void addRows(PdfPTable table, List<String> usersToString) {

        for (String user : usersToString) {
            String[] strings = user.split(";");
            for (int i = 0; i < strings.length; i++) {
                if (!strings[i].equals("")) {
                    table.addCell(strings[i]);
                } else
                    table.addCell("-");
            }
        }
    }

    public static File createDirectory(String directoryPathName, String pdfReports) {
        File theDir = new File("/" + directoryPathName + "/" + pdfReports);
        if (!theDir.exists()){
            theDir.mkdirs();
        }

        return theDir;
    }

    public static File createFile(File directory, String pdfReportName) {
        File theDir = new File(directory, pdfReportName);
//        if (!theDir.exists()){
//            theDir.mkdirs();
//        }

        return theDir;

    }


//    public static byte[] toByteArray(FileInputStream fileInputStream) {
//        byte[] bArr = ByteBuffer.wrap(FileUtils.readFileToByteArray(new File(filePathToVeryLargeFileInGBs)));
//    }

//        table.addCell("row 1, col 1");
//        table.addCell("row 1, col 2");
//        table.addCell("row 1, col 3");
}

//    private void addCustomRows(PdfPTable table)
//            throws URISyntaxException, BadElementException, IOException {
//        Path path = Paths.get(ClassLoader.getSystemResource("Java_logo.png").toURI());
//        Image img = Image.getInstance(path.toAbsolutePath().toString());
//        img.scalePercent(10);
//
//        PdfPCell imageCell = new PdfPCell(img);
//        table.addCell(imageCell);
//
//        PdfPCell horizontalAlignCell = new PdfPCell(new Phrase("row 2, col 2"));
//        horizontalAlignCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//        table.addCell(horizontalAlignCell);
//
//        PdfPCell verticalAlignCell = new PdfPCell(new Phrase("row 2, col 3"));
//        verticalAlignCell.setVerticalAlignment(Element.ALIGN_BOTTOM);
//        table.addCell(verticalAlignCell);
//    }

