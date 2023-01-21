package se.jensenyh.javacourse.saltmerch.backend;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import se.jensenyh.javacourse.saltmerch.backend.controller.CartController;
import se.jensenyh.javacourse.saltmerch.backend.service.CartService;

import static org.assertj.core.api.Assertions.assertThat;

@WebMvcTest(CartController.class)
public class Test
{
    @Autowired
    MockMvc mockMvc;
    @MockBean
    CartService service;

    final String baseUrl = "/api/v1/";

    @BeforeAll
    public void testMessage (){
        System.out.println("Starting all the test...");
    }
    @BeforeEach
    public void beforeEachTest (){
        System.out.println("Testing...");
    }
    @AfterEach
    public void afterEachTest () {
        System.out.println("Test done...");
    }
    @AfterAll
    public void afterAllTest () {
        System.out.println("Testing done!");
    }

}
