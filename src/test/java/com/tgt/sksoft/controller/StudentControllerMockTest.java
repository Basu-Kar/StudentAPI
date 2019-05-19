package com.tgt.sksoft.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.tgt.sksoft.model.Student;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.tgt.sksoft.common.Constants.API_VERSION;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Profile("unit")
@ActiveProfiles("unit")

public class StudentControllerMockTest {

    @Autowired
    private MockMvc mockMvc;

    private  Student student;

    @BeforeEach
    public void preTest(){
        student = Student.builder().firstName("Basu").lastName("Kar").rollNumber(1).build();
    }

    @Test
    public void createStudentTest() throws  Exception{
        student = Student.builder().firstName("Basu").lastName("Kar").rollNumber(1).build();

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


    @Test
    public void getStudentTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(API_VERSION+"students/1")).andDo(print())
        .andExpect(status().isOk());

    }

    @Test
    public void studentNotFoundTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(API_VERSION+"students/4")).andDo(print())
                .andExpect(status().isNotFound());

    }
}