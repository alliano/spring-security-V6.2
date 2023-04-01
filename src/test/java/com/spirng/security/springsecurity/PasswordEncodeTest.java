package com.spirng.security.springsecurity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordEncodeTest {

    
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }   

    @Test
    public void testEnc() {
        log.info("PASSWORD {} ", passwordEncoder.encode("test123"));
    }
}
