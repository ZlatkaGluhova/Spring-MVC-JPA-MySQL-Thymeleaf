package com.management.system.demo.service;

import com.management.system.demo.model.Employer;

import java.util.List;

public interface EmployerService {

    List<Employer> getAllEmployers();

    void saveEmployer(Employer employer);

    Employer getEmployerById(Long id);
}
