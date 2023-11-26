package com.spirng.security.springsecurity.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class AuthenticationRequest {
    
    private String email;

    private String password;
}
