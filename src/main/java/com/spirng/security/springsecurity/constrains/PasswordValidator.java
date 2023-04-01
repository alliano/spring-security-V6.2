package com.spirng.security.springsecurity.constrains;

import com.spirng.security.springsecurity.dtos.UserRegisterRequestDto;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<RetypePassMathcWIthPass, UserRegisterRequestDto>{

    @Override
    public boolean isValid(UserRegisterRequestDto loginDto, ConstraintValidatorContext context) {
        if(loginDto.getPassword() == null || loginDto.getRetypePassword() == null) return true;
        return loginDto.getRetypePassword().equals(loginDto.getPassword());
    }
}
