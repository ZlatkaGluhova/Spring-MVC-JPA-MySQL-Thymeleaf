package com.management.system.demo.utils;

import com.management.system.demo.model.User;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                for (String data: mappedDataToString){
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
        for (String data: mappedDataToString){
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
                .forEach(entry ->  System.out.printf(element + " with %s: %s is not found!%n", entry.getKey(), entry.getValue()));
    }
}
