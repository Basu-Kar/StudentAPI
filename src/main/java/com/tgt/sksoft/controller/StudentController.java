package com.tgt.sksoft.controller;

import com.tgt.sksoft.model.Student;
import com.tgt.sksoft.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/{student_id}")
    public Student getStudent(Long studentId){

        return studentService.getStudent(1L);
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){

        return studentService.createStudent(student);
    }
}