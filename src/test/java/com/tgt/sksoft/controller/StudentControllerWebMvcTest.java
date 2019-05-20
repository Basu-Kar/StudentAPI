package com.tgt.sksoft.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.tgt.sksoft.model.Student;
import com.tgt.sksoft.service.StudentServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.tgt.sksoft.common.Constants.API_VERSION;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @WebMvcTest @WebMvcTest is used t o test only the MVC with Spring Boot is only instantiating the web layer, not the whole context.
 * In an application with multiple controllers you can even ask for just one to be instantiated, using, for example @WebMvcTest(StudentController.class)
 * Spring Boot is only instantiating the web layer, not the whole context.
 * @MockBean to create and inject a mock for the
 */
@RunWith(SpringRunner.class)
@WebMvcTest(StudentController.class)
public class StudentControllerWebMvcTest {

    @Autowired
    private MockMvc mockMvc;

    private  Student student;

    @MockBean
    private StudentServiceImpl studentService;


    @BeforeEach
    public void preTest(){
        student = Student.builder().firstName("Basu").lastName("Kar").rollNumber(1).build();
    }

    @Test
    public void createStudentTest() throws  Exception{
        student = Student.builder().firstName("Basu").lastName("Kar").rollNumber(1).build();
        given(studentService.createStudent(student)).willReturn(student);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.SNAKE_CASE);

        String body = mapper.writeValueAsString(student);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(API_VERSION+"students")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        String resultDOW = result.getResponse().getContentAsString();
        assertNotNull(resultDOW);
    }

}
