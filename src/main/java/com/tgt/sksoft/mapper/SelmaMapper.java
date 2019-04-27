package com.tgt.sksoft.mapper;

import com.tgt.sksoft.StudentDTO;
import com.tgt.sksoft.model.Student;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL)
public interface SelmaMapper {

    //@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    StudentDTO asStudentDTO(Student studentModel);

    //@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
    Student asStudent(StudentDTO studentDTO);
}