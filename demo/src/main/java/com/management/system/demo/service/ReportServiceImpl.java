package com.management.system.demo.service;

import com.management.system.demo.model.Role;
import com.management.system.demo.model.User;
import com.management.system.demo.utils.FileOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class ReportServiceImpl implements ReportService {

    public static final List<String> headers = new ArrayList<>(Arrays.asList("ID", "USERNAME", "PASSWORD", "CREATED_ON", "UPDATED_ON", "EMAIL", "AGE", "IS_ACTIVE", "ROLE"));

    @Autowired
    private UserService userService;


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


}
