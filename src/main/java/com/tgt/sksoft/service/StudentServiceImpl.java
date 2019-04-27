package com.tgt.sksoft.service;

import com.tgt.sksoft.StudentDTO;
import com.tgt.sksoft.mapper.SelmaMapper;
import com.tgt.sksoft.model.Student;
import fr.xebia.extras.selma.Selma;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    SelmaMapper mapper = Selma.builder(SelmaMapper.class).build();


    @Override
    public Student createStudent(Student student) {
        student.getFirstName();
        StudentDTO studentDTO = mapper.asStudentDTO(student);
        log.info("Student DTO after conversion: "+studentDTO);

        Student studentModel = mapper.asStudent(studentDTO);

        return studentModel;
    }

    @Override
    public Student getStudent(Long studentId) {
        return null;
    }
}
