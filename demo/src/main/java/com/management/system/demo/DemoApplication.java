package com.management.system.demo;

import com.management.system.demo.dto.request.UserCreateDTORequest;
import com.management.system.demo.enums.Country;
import com.management.system.demo.enums.DepartmentName;
import com.management.system.demo.enums.RoleType;
import com.management.system.demo.enums.Status;
import com.management.system.demo.model.*;
import com.management.system.demo.service.DepartmentService;
import com.management.system.demo.service.EmployeeService;
import com.management.system.demo.service.EmployerService;
import com.management.system.demo.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class DemoApplication {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

//    @Bean
//    InitializingBean sendMockDataToDatabase() {
//        return () -> {
//            createDepartments();
//            createEmployers();
//            createEmployees();
//            createUsers();
//
//        };
//    }

    @Bean
    InitializingBean Test() {
        return () -> {
        myTest();

        };
    }

    private void myTest() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println("---------------------------------------------- START");
        System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH).format(ldt));
        System.out.println(DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt));
        System.out.println(ldt);
        System.out.println("----------------------------");
        LocalDate birthDate;
        birthDate = LocalDate.now();
        System.out.println(birthDate);


        birthDate = LocalDate.of(1995, 4, 28);
        System.out.println(birthDate);
        LocalDate dateNow = LocalDate.now();
        Integer test = Period.between(birthDate, dateNow).getYears();
        System.out.printf("User is %d years old%n", test);


        birthDate = LocalDate.parse("08-02-2020", DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println(birthDate);
        System.out.println("---------------------------------------------- END");
    }


    private void createDepartments() {
        departmentService.saveDepartment(new Department(DepartmentName.IT, 0, true));
        departmentService.saveDepartment(new Department(DepartmentName.HR, 0, false));
        departmentService.saveDepartment(new Department(DepartmentName.FINANCE, 0, false));
    }

    private void createEmployers() {
        employerService.saveEmployer(new Employer("Vasil", "Vasilev", Country.BULGARIA, BigDecimal.valueOf(15000), departmentService.getDepartmentById(1L), LocalDateTime.now()));
        employerService.saveEmployer(new Employer("Ivan", "Ivanov", Country.BULGARIA, BigDecimal.valueOf(9000), departmentService.getDepartmentById(2L), LocalDateTime.now()));
        employerService.saveEmployer(new Employer("Dimo", "Dimov", Country.BULGARIA, BigDecimal.valueOf(10000), departmentService.getDepartmentById(3L), LocalDateTime.now()));
    }

    private void createEmployees() {
        employeeService.saveEmployee(new Employee("Maria", "Petrova", "maria@abv.bg", 25, departmentService.getDepartmentById(1L), BigDecimal.valueOf(5000), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Stefan", "Stefanov", "stefan@abv.bg", 33, departmentService.getDepartmentById(1L), BigDecimal.valueOf(8000), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Andrey", "Andreev", "andrey@abv.bg", 31, departmentService.getDepartmentById(2L), BigDecimal.valueOf(7000), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Peter", "Petrov", "peter@abv.bg", 25, departmentService.getDepartmentById(3L), BigDecimal.valueOf(4000), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Iva", "Ivanova", "iva@abv.bg", 28, departmentService.getDepartmentById(1L), BigDecimal.valueOf(5500), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Anna", "Andonova", "anna@abv.bg", 24, departmentService.getDepartmentById(3L), BigDecimal.valueOf(3500), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Petya", "Vasileva", "petya@abv.bg", 35, departmentService.getDepartmentById(1L), BigDecimal.valueOf(9000), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Yavor", "Yavorov", "yavor@abv.bg", 29, departmentService.getDepartmentById(1L), BigDecimal.valueOf(7500), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Anton", "Antonov", "anton@abv.bg", 30, departmentService.getDepartmentById(2L), BigDecimal.valueOf(6000), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Todor", "Todorov", "todor@abv.bg", 38, departmentService.getDepartmentById(1L), BigDecimal.valueOf(9500), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("George", "Georgiev", "george@abv.bg", 34, departmentService.getDepartmentById(3L), BigDecimal.valueOf(8300), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Stanislav", "Stanislavov", "stanislav@abv.bg", 36, departmentService.getDepartmentById(1L), BigDecimal.valueOf(7800), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Nikola", "Nikolov", "nikola@abv.bg", 35, departmentService.getDepartmentById(3L), BigDecimal.valueOf(8800), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Kameliya", "Kamenova", "kameliya@abv.bg", 29, departmentService.getDepartmentById(1L), BigDecimal.valueOf(4500), LocalDateTime.now(), Status.ACTIVE));
        employeeService.saveEmployee(new Employee("Zlatin", "Zlatinov", "zlatin@abv.bg", 36, departmentService.getDepartmentById(3L), BigDecimal.valueOf(9500), LocalDateTime.now(), Status.ACTIVE));
    }

    private void createUsers() {
            userService.saveUser(new UserCreateDTORequest("vasil_vasilev", "Vasil358*", "vasil@abv.bg", 26));
            userService.saveUser(new UserCreateDTORequest("ivan_ivanov", "Ivan358*", "ivan@abv.bg", 38));
            userService.saveUser(new UserCreateDTORequest("dimo_dimov", "Dimo358*", "dimo@abv.bg", 32));

    }
//
//    private List<Role> createRoles() {
//        List<Role> rolesList = new ArrayList<>();
//
//
//        return rolesList;
//    }

}
