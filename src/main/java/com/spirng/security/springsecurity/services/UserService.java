package com.spirng.security.springsecurity.services;

import org.springframework.http.ResponseEntity;
// import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.spirng.security.springsecurity.dtos.UserRegisterRequestDto;

public interface UserService extends UserDetailsService {

    public ResponseEntity<?> findAllStudents();

    public ResponseEntity<Void> register(UserRegisterRequestDto user);

    public ResponseEntity<?> getCurrentLogin();
    
}
