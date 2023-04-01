package com.spirng.security.springsecurity.constrains;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {PasswordValidator.class})
public @interface RetypePassMathcWIthPass {
    
    public String message() default "password and retype password should be same";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
