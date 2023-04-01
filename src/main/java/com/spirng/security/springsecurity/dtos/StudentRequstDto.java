package com.spirng.security.springsecurity.dtos;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.spirng.security.springsecurity.domains.entities.Role;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Setter @Getter
public class StudentRequstDto {
    
    @NotBlank(message = "first name is required !")
    private String firstName;
    
    @NotBlank(message = "first name is required !")
    private String lastName;
    
    @NotNull(message = "role is required !")
    private List<Role> roles;
}
