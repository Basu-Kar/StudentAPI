package com.tgt.sksoft.service;

import com.tgt.sksoft.model.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);
    Student getStudent(Long studentId);

    List<Student> getAllStudents();
}
