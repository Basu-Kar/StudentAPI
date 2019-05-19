package com.tgt.sksoft.service;

import com.tgt.sksoft.dto.StudentDTO;
import com.tgt.sksoft.exception.RecordNotFoundException;
import com.tgt.sksoft.mapper.MapstructMapper;
import com.tgt.sksoft.model.Student;
import com.tgt.sksoft.repositories.StudentDTORepository;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentServiceImpl implements StudentService {

    //private SelmaMapper mapper = Selma.builder(SelmaMapper.class).build();
    private MapstructMapper mapper = Mappers.getMapper( MapstructMapper.class );

    @Autowired
    private StudentDTORepository studentDTORepository;

    @Override
    public Student createStudent(Student student) {
        student.getFirstName();
        StudentDTO studentDTO = mapper.asStudentDTO(student);
        log.info("Student DTO after conversion: "+studentDTO);
        studentDTORepository.save(studentDTO);
        Student studentModel = mapper.asStudent(studentDTO);

        return studentModel;
    }

    @Override
    public Student getStudent(Long studentId) {
        StudentDTO studentDTO =  studentDTORepository.findStudentDTOByStudentId(studentId);
       if(studentDTO ==null){
           throw new RecordNotFoundException("Record Not Found");
       }
        Student studentModel = mapper.asStudent(studentDTO);
        return studentModel;
    }

    @Override
    public List<Student> getAllStudents() {
        Iterable<StudentDTO> studentDTOList = studentDTORepository.findAll();
        List<Student> list = new ArrayList<>();
        studentDTOList.forEach(studentDTO -> {list.add(mapper.asStudent(studentDTO));});
        return list;
    }
}
