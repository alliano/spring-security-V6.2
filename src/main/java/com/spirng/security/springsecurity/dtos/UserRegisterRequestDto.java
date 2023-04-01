package com.spirng.security.springsecurity.dtos;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.spirng.security.springsecurity.constrains.RetypePassMathcWIthPass;
import com.spirng.security.springsecurity.domains.entities.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
@Setter @Getter @RetypePassMathcWIthPass(message = "{login.passandretype.invalid}")
public class UserRegisterRequestDto implements Serializable {
    
    private static final long serialVersionUID = -4892376476287L;

    @Email(message = "invalid email")
    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "password is required")
    private String password;

    @NotBlank(message = "retype password is required")
    private String retypePassword;

    @NotNull(message = "role is required")
    private List<@NotBlank(message = "role name is reqired")Role> roles;
}
