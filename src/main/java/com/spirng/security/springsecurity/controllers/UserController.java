package com.spirng.security.springsecurity.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spirng.security.springsecurity.dtos.LoginRequestDto;
import com.spirng.security.springsecurity.dtos.UserRegisterRequestDto;
import com.spirng.security.springsecurity.services.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController @RequestMapping(method = {RequestMethod.GET}, path = "/v1")
public class UserController {

    private final UserService userService;
    
    @PostMapping(path = "/register")
    private ResponseEntity<Void> register(@RequestBody @Valid UserRegisterRequestDto user) {
        return this.userService.register(user);
    }

    @GetMapping(path = "/v1/login")
    public ResponseEntity<?> getCurrentLogin(@RequestBody LoginRequestDto lognReq) {
        return this.userService.getCurrentLogin();
    }
}
