package com.spirng.security.springsecurity.security.handlers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

/**
 * kelas yang akan menghandle jika gagal autentikasi
 */
@AllArgsConstructor
public class UsernamePasswordAuthFalureHandler implements AuthenticationFailureHandler {

    private final ObjectMapper objectMapper;

    /**
     * respon yang akan di kemabalikan ketika gagal autentikasi
     */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,  AuthenticationException exception) throws IOException, ServletException {
        Map<String, String> resultMap = new HashMap<String, String>();
        resultMap.put("result", "FAILED");
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        this.objectMapper.writeValue(response.getWriter(), resultMap);
    }
    
}
