package com.management.system.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.management.system.demo.dto.request.UserCreateDTORequest;
import com.management.system.demo.dto.response.UserCreateDTOResponse;
import com.management.system.demo.helper.TestHelper;
import com.management.system.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserControllerTest {

    private static final String END_POINT_PATH = "users";

//    @InjectMocks
//
//    @Mock
//    @InjectMocks
//    @MockBean
    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

//    @BeforeAll
//    public void beforeAll() {
//        System.out.println("beforeAll");
////        MockitoAnnotations.openMocks(UserControllerTest.class);
//    }

//    @AfterAll
//    public void afterAll() {
//        System.out.println("afterAll");
////        MockitoAnnotations.openMocks(UserControllerTest.class);
//    }

    @Test
    void testCreateUser_Success() throws Exception {
        //arrange
        UserCreateDTORequest userCreateDTORequest = TestHelper.createUser();
//        doNothing().when(userService).saveUser(userCreateDTORequest);
        //act
        UserCreateDTOResponse userCreateDTOResponse = userService.saveUser(userCreateDTORequest);

        //assert
//        verify(userService).saveUser(userCreateDTORequest);
        assertEquals(userCreateDTORequest.getUsername(),userCreateDTOResponse.getUsername());
    }

    @Test
    void getUserById() {

    }

    @Test
    void updateUser() {

    }

    @Test
    void deleteUser() {

    }
}