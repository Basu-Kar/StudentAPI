package com.tgt.sksoft.controller;

import com.tgt.sksoft.model.Student;
import com.tgt.sksoft.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tgt.sksoft.common.Constants.API_VERSION;



@RestController
@RequestMapping(API_VERSION)
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("students/{student_id}")
    public Student getStudent(@PathVariable("student_id") Long studentId){

        return studentService.getStudent(studentId);
    }

    @GetMapping("students")
    public List<Student> getAllStudents(){

        return studentService.getAllStudents();
    }

    @PostMapping("students")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){

        return studentService.createStudent(student);
    }
}
