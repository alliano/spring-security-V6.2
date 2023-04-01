package com.spirng.security.springsecurity.services.impl;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.spirng.security.springsecurity.domains.entities.Student;
import com.spirng.security.springsecurity.domains.repositories.StudentRepository;
import com.spirng.security.springsecurity.dtos.StudentRequstDto;
import com.spirng.security.springsecurity.services.StudentService;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public ResponseEntity<?> addStudents(StudentRequstDto studentReq) {
        Student student = new Student();
        student.setFirstName(studentReq.getFirstName());
        student.setLastName(studentReq.getLastName());
        student.setRoles(studentReq.getRoles());
        student.setCreatedAt(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(this.studentRepository.save(student));
    }
    
}
