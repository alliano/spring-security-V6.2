package com.spirng.security.springsecurity.services.impl;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spirng.security.springsecurity.domains.entities.ApplicationUser;
import com.spirng.security.springsecurity.domains.repositories.StudentRepository;
import com.spirng.security.springsecurity.domains.repositories.UserRepositories;
import com.spirng.security.springsecurity.dtos.UserRegisterRequestDto;
import com.spirng.security.springsecurity.exceptions.ResourceNotFoundException;
import com.spirng.security.springsecurity.services.UserService;

import lombok.AllArgsConstructor;

@Service @AllArgsConstructor
public class UserDetailServiceImpl implements UserService {

    private final UserRepositories userRepositories;

    private final StudentRepository studentRepository;


    @Override
    public ResponseEntity<?> findAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(this.studentRepository.findAll());
    }

    @Override
    public ResponseEntity<Void> register(UserRegisterRequestDto user) {
        ApplicationUser applicationUser = new ApplicationUser();
        applicationUser.setEmail(user.getEmail());
        applicationUser.setPassword(applicationUser.getPassword());
        applicationUser.setCreatedAt(LocalDateTime.now());
        this.userRepositories.save(applicationUser);
        return ResponseEntity.ok().build();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
       return this.userRepositories.findByEmail(email).orElseThrow(() -> new ResourceNotFoundException("email "+email+" notfound"));
    }

    @Override
    public ResponseEntity<?> getCurrentLogin() {
        return ResponseEntity.ok().body("Alliano");
    }
    
}
