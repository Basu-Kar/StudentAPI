package com.tgt.sksoft.mapper;

import com.tgt.sksoft.dto.StudentDTO;
import com.tgt.sksoft.model.Student;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL)
public interface SelmaMapper {

    //@Maps(withIgnoreMissing = IgnoreMissing.DESTINATION)
    StudentDTO asStudentDTO(Student studentModel);

    //@Maps(withIgnoreMissing = IgnoreMissing.SOURCE)
    Student asStudent(StudentDTO studentDTO);
}
