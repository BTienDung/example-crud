package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student save(Student student){
       return studentRepository.save(student);
    }

    public void deleteStudent(Long id) throws Exception {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()){
            studentRepository.deleteById(id);
        }else {
            throw new Exception("Id not found");
        }

    }

}
