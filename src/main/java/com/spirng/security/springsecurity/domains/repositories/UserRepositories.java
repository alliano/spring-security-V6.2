package com.spirng.security.springsecurity.domains.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirng.security.springsecurity.domains.entities.ApplicationUser;


public interface UserRepositories extends JpaRepository<ApplicationUser, Long> {

    public Optional<ApplicationUser> findByEmail(String email);
}
