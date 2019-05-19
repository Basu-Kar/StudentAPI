package com.tgt.sksoft.repository;

import com.tgt.sksoft.dto.StudentDTO;
import com.tgt.sksoft.repositories.StudentDTORepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


@DataJpaTest
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:schema-hsqldb.sql")
public class StudentRepositoryTest {

    @Autowired
    private StudentDTORepository studentDTORepository;



    @Test
    public void getStudentTest(){

        StudentDTO studentDTO = studentDTORepository.findStudentDTOByStudentId(101L);
        Assertions.assertNotNull(studentDTO);
    }


    @Test
    public void getAllStudentTest(){
        StudentDTO studentDTO1 = StudentDTO.builder().studentId(102L).firstName("").lastName("Kar").studentId(100L).build();
        studentDTORepository.save(studentDTO1);
        Iterable<StudentDTO> studentDTOList = studentDTORepository.findAll();
        Assertions.assertNotNull(studentDTOList);

    }
}
