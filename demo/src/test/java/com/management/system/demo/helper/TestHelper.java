package com.management.system.demo.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.management.system.demo.enums.Country;
import com.management.system.demo.model.Employer;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static Employer createEmployer(Long id) {
        Employer employer = new Employer();
        employer.setId(id);
        employer.setFirstName("Pesho");
        employer.setLastName("Ivanov");
        employer.setCountry(Country.BULGARIA);
        employer.setSalary(BigDecimal.valueOf(9000));
        employer.setCreatedOn(LocalDateTime.now());

        return employer;
    }

    public static Employer createEmployer(Long id, LocalDateTime createdOn) {
        Employer employer = createEmployer(id);
        employer.setCreatedOn(createdOn);
        return employer;
    }

    public static String asJsonString(final Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Employer> createEmployerList(){
        List<Employer> employers = new ArrayList<>();
        employers.add(TestHelper.createEmployer(1L));
        employers.add(TestHelper.createEmployer(2L));
        employers.add(TestHelper.createEmployer(3L));

        return employers;
    }
}
