package com.hcl.springdatajps.service;

import com.hcl.springdatajps.dao.StudentRepository;
import com.hcl.springdatajps.data.StudentKey;
import com.hcl.springdatajps.json.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMappingService studentMappingService;

    public Student getStudentById(Long id, String email) {
        return studentRepository
                .findById(new StudentKey(id, email))
                .map(studentMappingService::getStudentResponse)
                .orElseThrow(() -> new IllegalStateException(String.format("Student with student id: %s and email: %s not found", id, email)));
    }

    public List<Student> getStudents() {
        return studentRepository
                .findAll()
                .stream()
                .map(studentMappingService::getStudentResponse)
                .collect(Collectors.toList());
    }

    public Student saveStudents(Student student) {
        return Optional
                .of(student)
                .map(studentMappingService::getStudentData)
                .map(studentRepository::save)
                .map(studentMappingService::getStudentResponse)
                .orElseThrow(() -> new RuntimeException("Failed while saving the data"));
    }
}