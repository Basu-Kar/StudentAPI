package com.tgt.sksoft.repositories;

import com.tgt.sksoft.StudentDTO;
import org.springframework.data.repository.CrudRepository;

public interface StudentDTORepository extends CrudRepository<StudentDTO, Long> {

    StudentDTO findStudentDTOByStudentId(Long studentId);
}
