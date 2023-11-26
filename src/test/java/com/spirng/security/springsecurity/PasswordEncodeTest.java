package com.spirng.security.springsecurity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spirng.security.springsecurity.dao.UserDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest(classes = SpringSecurityApplication.class)
class PasswordEncodeTest {

    @Autowired @Qualifier(value = "BcryptPasswordEncoder")
    private PasswordEncoder encoder;

    @Autowired
    private UserDao userDao;

    @Test
    void passwordEncoder() {
        String encode = this.encoder.encode("password_rahasia");
        log.info("Password : "+encode);
    }

    @Test
    public void testAuthentication() {
        UserDetails userDetail = this.userDao.findByEmail("allianoanonymous@gmail.com");
        Assertions.assertNotNull(userDetail);
        String password = userDetail.getPassword();
        boolean matches = this.encoder.matches("password_rahasia", password);
        Assertions.assertTrue(matches);
        log.info(userDetail.getUsername());
    }
}
