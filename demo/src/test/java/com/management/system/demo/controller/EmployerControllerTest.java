package com.management.system.demo.controller;

import com.management.system.demo.enums.ConstantType;
import com.management.system.demo.helper.TestHelper;
import com.management.system.demo.model.Employer;
import com.management.system.demo.service.DepartmentService;
import com.management.system.demo.service.EmployeeService;
import com.management.system.demo.service.EmployerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class EmployerControllerTest {

    @MockBean
    private EmployerService employerService;

    @MockBean
    private EmployeeService employeeService;

    @MockBean
    private DepartmentService departmentService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void saveEmployer() throws Exception {
        //arrange
        Employer employer = TestHelper.createEmployer(null);
//        String requestBody = TestHelper.asJsonString(employer);

        doNothing().when(employerService).saveEmployer(employer);


        String url = "/employer/saveEmployer";
        ResultActions result = mockMvc.perform(post(url)
                .flashAttr("employer", employer));
        result.andExpect(status().is3xxRedirection());
        result.andExpect(view().name(ConstantType.EMPLOYER.getRedirectType()));

        verify(employerService).saveEmployer(employer);


//                .andExpect(model().attributeExists("employer"))
//        ResultActions resultActions = result.andExpect(status().is3xxRedirection()).andExpect(view().name(ConstantType.EMPLOYER.getRedirectType()));
        //        String jsonResponse = mvcResult.getResponse().getContentAsString();

//        @PostMapping("/saveEmployer")
//        public String saveEmployer(@ModelAttribute("employer") Employer employer) {
//            //save employee to db
//            employerService.saveEmployer(employer);
//
//            return ConstantType.EMPLOYER.getRedirectType();
//        }

    }

    @Test
    public void showEmployers() throws Exception {
        List<Employer> employers = TestHelper.createEmployerList();

        when(employerService.getAllEmployers()).thenReturn(employers);

        String url = "/employer";
        ResultActions result = mockMvc.perform(get(url)
                .flashAttr("listEmployers", employers));
        result.andExpect(status().isOk());
        result.andExpect(view().name(ConstantType.EMPLOYER.getListType()));
        result.andExpect(model().attributeExists("listEmployers"));

        verify(employerService).getAllEmployers();
//        andExpect(model().attributeExists("employer"))
//        ResultActions resultActions = result.andExpect(status().isOk())
//                .andExpect(view().name(ConstantType.EMPLOYER.getRedirectType()));

//        String jsonResponse = mvcResult.getResponse().getContentAsString();

//        @GetMapping
//        public String showEmployers(Model model) {
//            List<Employer> employers = employerService.getAllEmployers();
//            model.addAttribute("listEmployers", employers);
//
//            return ConstantType.EMPLOYER.getListType();
//        }


    }


    @Test
    public void showNewEmployerForm() throws Exception {

        Employer employer = new Employer();
//        String requestBody = TestHelper.asJsonString(employer);

//        doNothing().when(employerService).saveEmployer(employer);


        String url = "/employer/showNewEmployerForm";
        ResultActions result = mockMvc.perform(get(url)
                .flashAttr(ConstantType.EMPLOYER.getType(), employer));
        result.andExpect(status().isOk());
        result.andExpect(view().name(ConstantType.EMPLOYER.getNewType()));
        result.andExpect(model().attributeExists(ConstantType.EMPLOYER.getType()));

    }


    @Test
    public void showFormForUpdate() throws Exception {
        Long id = 1L;
        Employer employer = TestHelper.createEmployer(id);
//        String requestBody = TestHelper.asJsonString(employer);

        when(employerService.getEmployerById(id)).thenReturn(employer);


        String url = "/employer/showFormForUpdate/{id}";
        ResultActions result = mockMvc.perform(get(url, id)
                .flashAttr(ConstantType.EMPLOYER.getType(), employer));
        result.andExpect(status().isOk());
        result.andExpect(view().name(ConstantType.EMPLOYER.getUpdateType()));
        result.andExpect(model().attributeExists(ConstantType.EMPLOYER.getType()));

        verify(employerService).getEmployerById(id);
//        @GetMapping("/showFormForUpdate/{id}")
//        public String showFormForUpdate(@PathVariable(value = Constant.ID) Long id, Model model) {
//
//            //get the model from the service
//            Employer employer = employerService.getEmployerById(id);

//            //set employee as a model attribute to pre-populate the form
//            model.addAttribute(ConstantType.EMPLOYER.getType(), employer);

//            return ConstantType.EMPLOYER.getUpdateType();
//        }

    }


}