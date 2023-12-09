package com.management.system.demo.service;

import com.management.system.demo.helper.TestHelper;
import com.management.system.demo.model.Employer;
import com.management.system.demo.repository.EmployerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    public void testGetAllEmployers_Success() {
//        List<Employer> employers = TestHelper.createEmployerList();

        employerService.getAllEmployers();

//        assertEquals(employerService.getAllEmployers(), employers);

//        verify(employerService).getAllEmployers();
    }

    @Test
    public void testSaveEmployerWithId_Success() {
        Employer employer = TestHelper.createEmployer(1L);

        employerService.saveEmployer(employer);

//        verify(employerService, times(1)).saveEmployer(employer);
//        verify(employerService).saveEmployer(employer);
//        assertEquals(employer.getFirstName(), employerFromDB.getFirstName());
    }

    @Test
    public void testSaveEmployerWithoutId_Success() {
        Employer employer = TestHelper.createEmployer(null);

        employerService.saveEmployer(employer);

    }

    @Test
    public void testGetEmployerById_Success() {
        Employer employer = TestHelper.createEmployer(2L);

        employerService.getEmployerById(employer.getId());

    }
}