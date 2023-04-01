package com.spirng.security.springsecurity.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(callSuper = false)
@Setter @Getter
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
    
    private static final long serialVersionUID = -387429764372L;

    private String message;

    public BadRequestException(String message) {
        this.message = message;
    }
}
