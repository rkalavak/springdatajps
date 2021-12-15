package com.hcl.springdatajps.service;

import com.hcl.springdatajps.data.StudentData;
import com.hcl.springdatajps.json.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentMappingService {

    public Student getStudentResponse(StudentData studentData) {
        return Student
                .builder()
                .id(studentData.getId())
                .name(studentData.getName())
                .email(studentData.getEmail())
                .age(studentData.getAge())
                .build();
    }

    public StudentData getStudentData(Student student) {
        return StudentData
                .builder()
                .name(student.getName())
                .email(student.getEmail())
                .age(student.getAge())
                .build();
    }
}
