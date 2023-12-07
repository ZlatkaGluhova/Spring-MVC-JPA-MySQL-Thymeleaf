package com.management.system.demo.repository;

import com.management.system.demo.enums.Country;
import com.management.system.demo.helper.TestHelper;
import com.management.system.demo.model.Employer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployerRepositoryTest {

    @Autowired
    private EmployerRepository employerRepository;

    @Test
    void itShouldFindAllEmployers() {
        //given - input
        employerRepository.save(TestHelper.createEmployer(11L));
        employerRepository.save(TestHelper.createEmployer(15L));

        //when
        List<Employer> expectedEmployerList = employerRepository.findAll();


        //then - assert
        assertThat(expectedEmployerList).isNotEmpty();



    }

}
