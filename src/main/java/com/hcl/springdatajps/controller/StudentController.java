package com.hcl.springdatajps.controller;

import com.hcl.springdatajps.json.Student;
import com.hcl.springdatajps.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody @NotNull Student student) {
        Student studentResponse = studentService.saveStudents(student);
        return ResponseEntity.ok(studentResponse);
    }

    @GetMapping("{id}/{email}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") @NotNull Long id,
                                                  @PathVariable("email") @NotNull String email) {
        Student student = studentService.getStudentById(id, email);
        return ResponseEntity.ok(student);
    }
}