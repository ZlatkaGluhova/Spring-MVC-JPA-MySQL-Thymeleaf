package com.management.system.demo.service;

import com.management.system.demo.helper.TestHelper;
import com.management.system.demo.model.Employer;
import com.management.system.demo.repository.EmployerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class EmployerServiceTest {

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private EmployerService employerService;

    @Test
    public void getAllEmployers() {
    }

    @Test
    public void testSaveEmployerWithId_Success() {
        Employer employer = TestHelper.createEmployer(1L);

        employerService.saveEmployer(employer);

        verify(employerService, times(1)).saveEmployer(employer);
//        assertEquals(employer.getFirstName(), employerFromDB.getFirstName());
    }

    @Test
    public void testSaveEmployerWithoutId_Success() {
    }

    @Test
    public void getEmployerById() {
    }
}