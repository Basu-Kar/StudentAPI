package com.tgt.sksoft.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.tgt.sksoft.model.Student;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.tgt.sksoft.common.Constants.API_VERSION;

/**
 * webEnvironment=RANDOM_PORT to start the server with a random port and the injection of the port with @LocalServerPort
 * Spring Boot has provided a TestRestTemplate for you automatically, and all you have to do is @Autowired it.
 *
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Profile("unit")
@ActiveProfiles("unit")
public class StudentControllerRandomPort {

    @LocalServerPort
    int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private Student student;

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

        ResponseEntity<String> result = this.restTemplate.postForEntity(API_VERSION+"students",student,String.class);
        Assertions.assertEquals(201, result.getStatusCodeValue());
        Assertions.assertEquals(true, result.getBody().contains("Basu"));
    }


}
