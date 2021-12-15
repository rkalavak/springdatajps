package com.hcl.springdatajps.dao;

import com.hcl.springdatajps.data.StudentData;
import com.hcl.springdatajps.data.StudentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentData, StudentKey> {
}
