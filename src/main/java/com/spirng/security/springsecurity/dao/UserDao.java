package com.spirng.security.springsecurity.dao;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    
    private static final List<UserDetails> users = Arrays.asList(
        new User("allianoanonymous@gmail.com", "$2a$10$TwhvEvToal1L0FhvLTFXz.wt0TEwEJKPLWZYN8FunxApx60xVBtFy", Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN "))),
        new User("abdilllah@gmail.com", "$2a$10$n2wx81On6s3.9R2JZXv4.Ofu8/6WNe9ZEiSRCXKwwQe7rssmTcD5e", Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")))
    );

    public UserDetails findByEmail(String email) {
        return users.stream()
            .filter(user -> user.getUsername().equals(email))
            .findFirst()
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
