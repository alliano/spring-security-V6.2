package com.spirng.security.springsecurity.services;

import org.springframework.http.ResponseEntity;

import com.spirng.security.springsecurity.dtos.StudentRequstDto;

public interface StudentService {
    
    public ResponseEntity<?> addStudents(StudentRequstDto student);
}
