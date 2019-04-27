package com.tgt.sksoft.service;

import com.tgt.sksoft.model.Student;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudent(Long studentId);
}
