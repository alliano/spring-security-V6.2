package com.spirng.security.springsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spirng.security.springsecurity.dtos.StudentRequstDto;
import com.spirng.security.springsecurity.services.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController @RequestMapping(method = RequestMethod.GET, path = "/v1")
public class StudentController {
    
    private final StudentService studentService;

    @PostMapping(path = "/create")
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentRequstDto student) {
       return this.studentService.addStudents(student);
    }
}
