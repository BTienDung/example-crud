package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student studentEntity = studentService.save(student);
        return new ResponseEntity<Student>(studentEntity, HttpStatus.OK);
    }
    @DeleteMapping("/students/{id}")
    public ResponseEntity createStudent(@PathVariable("id") Long studentId) throws Exception {
        studentService.deleteStudent(studentId);
        return new ResponseEntity(HttpStatus.OK);
    }
}
