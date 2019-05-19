package com.tgt.sksoft.mapper;

import com.tgt.sksoft.dto.StudentDTO;
import com.tgt.sksoft.model.Student;
import org.mapstruct.Mapper;

@Mapper
public interface MapstructMapper {

    StudentDTO asStudentDTO(Student studentModel);


    Student asStudent(StudentDTO studentDTO);
}
