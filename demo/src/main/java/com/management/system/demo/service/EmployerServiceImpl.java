package com.management.system.demo.service;

import com.management.system.demo.model.Employer;
import com.management.system.demo.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    private EmployerRepository employerRepository;

    @Override
    public List<Employer> getAllEmployers() {
        return employerRepository.findAll();
    }

    @Override
    public void saveEmployer(Employer employer) {
        if (employer.getId() != null){
            employer = mappedDataFromEmployerToEmployerDB(employer);
        } else {
            employer.setCreatedOn(LocalDateTime.now());
        }

        this.employerRepository.save(employer);
    }

    private Employer mappedDataFromEmployerToEmployerDB(Employer employer) {
        Employer employerFromDB = employerRepository.findById(employer.getId()).orElseThrow(() -> new RuntimeException("Employer not found for id : " + employer.getId()));

        employerFromDB.setFirstName(employer.getFirstName());
        employerFromDB.setLastName(employer.getLastName());
        employerFromDB.setCountry(employer.getCountry());
        employerFromDB.setSalary(employer.getSalary());
        employerFromDB.setUpdatedOn(LocalDateTime.now());

        return employerFromDB;
    }

    @Override
    public Employer getEmployerById(Long id) {
        Employer employer = employerRepository.findById(id).orElseThrow(() -> new RuntimeException("Employer not found for id : " + id));

        return employer;
    }
}
