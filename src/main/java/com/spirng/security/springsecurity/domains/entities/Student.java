package com.spirng.security.springsecurity.domains.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity @Setter @Getter
@Table(name = "student")
public class Student extends AbstracBaseEntity {
    
    private static final long serialVersionUID = 384297627364L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany
    @JoinTable(name = "studen_role", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "id")
    })
    private List<Role> roles;

}
