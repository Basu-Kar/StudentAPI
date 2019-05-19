package com.tgt.sksoft.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.tgt.sksoft.dto.StudentDTO;
import com.tgt.sksoft.model.Student;
import com.tgt.sksoft.repositories.StudentDTORepository;
import com.tgt.sksoft.service.StudentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static com.tgt.sksoft.common.Constants.API_VERSION;
import static org.junit.Assert.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * This will test only controller. Service and Repository is mocked.
 */
@RunWith(MockitoJUnitRunner.class)
public class StudentControllerPureMockUnitTest {

    private MockMvc mvc;

    @InjectMocks
    private StudentController studentController;

    @Mock
    private StudentServiceImpl studentService;

    //@Mock
   // private StudentDTORepository studentDTORepository;


    @Before
    public void setup() {
        // We would need this line if we would not use MockitoJUnitRunner
        // MockitoAnnotations.initMocks(this);
        // Initializes the JacksonTester
        JacksonTester.initFields(this, new ObjectMapper());
        // MockMvc standalone approach
        mvc = MockMvcBuilders.standaloneSetup(studentController)
                .build();
    }


    @Test
    public void canRetrieveByIdWhenExists() throws Exception {
        // given
        StudentDTO dto = StudentDTO.builder().build();
        Student model = Student.builder().build();

//        given(studentService.createStudent(model)).willReturn(model);
       // given(studentDTORepository.save(dto))
        //        .willReturn(dto);

        // when
        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.SNAKE_CASE);

        String body = mapper.writeValueAsString(model);


        MvcResult result = mvc.perform(MockMvcRequestBuilders.post(API_VERSION+"students")
                .content(body)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andReturn();
        String resultDOW = result.getResponse().getContentAsString();
        assertNotNull(resultDOW);

    }
}
