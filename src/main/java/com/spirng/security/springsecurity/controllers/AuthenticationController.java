package com.spirng.security.springsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spirng.security.springsecurity.configurations.JwtUtils;
import com.spirng.security.springsecurity.dao.UserDao;
import com.spirng.security.springsecurity.dto.AuthenticationRequest;

import lombok.AllArgsConstructor;

@RestController @AllArgsConstructor
@RequestMapping(path = "/api/v1/auth")
public class AuthenticationController {
    
    private final AuthenticationManager authenticationManager;

    private final UserDao userDao;

    private final JwtUtils jwtUtils;

    @PostMapping(path = "/authenticated")
    public ResponseEntity<String> authenticate(@RequestBody AuthenticationRequest authRequest){
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
        final UserDetails user = this.userDao.findByEmail(authRequest.getEmail());
        if(user != null){
            return ResponseEntity.ok().body(jwtUtils.generateToken(null, user));
        }
        return ResponseEntity.badRequest().body("Bad Request");
    }
}
