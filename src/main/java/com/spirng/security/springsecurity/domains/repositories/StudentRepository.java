package com.spirng.security.springsecurity.domains.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spirng.security.springsecurity.domains.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
