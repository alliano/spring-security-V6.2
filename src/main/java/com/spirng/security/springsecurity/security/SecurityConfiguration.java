package com.spirng.security.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spirng.security.springsecurity.security.filter.UsernamePasswordAuthProccessingFilter;
import com.spirng.security.springsecurity.security.handlers.UsernamePasswordAuthFalureHandler;
import com.spirng.security.springsecurity.security.handlers.UsernamePasswordAuthSuccessHandler;
import com.spirng.security.springsecurity.security.provider.UsernamePasswordAuthProvider;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebSecurity(debug = true) @AllArgsConstructor
@Configuration @EnableMethodSecurity
public class SecurityConfiguration {

    private final UsernamePasswordAuthProvider usernamePasswordAuthProvider;

    private static final String AUTH_URL = "/v1/login";

    @Bean
    public AuthenticationSuccessHandler successHandler(ObjectMapper objectMapper) {
        return new UsernamePasswordAuthSuccessHandler(objectMapper);
    }
    
    @Bean
    public AuthenticationFailureHandler failureHandler(ObjectMapper objectMapper) {
        return new UsernamePasswordAuthFalureHandler(objectMapper);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public UsernamePasswordAuthProccessingFilter usernamePasswordAuthProccessingFilter(ObjectMapper objectMapper, AuthenticationSuccessHandler successHandler, AuthenticationFailureHandler failureHandler, AuthenticationManager authManager){
        UsernamePasswordAuthProccessingFilter usernamePasswordAuthProccessingFilter = new UsernamePasswordAuthProccessingFilter(AUTH_URL, objectMapper, successHandler, failureHandler);
        usernamePasswordAuthProccessingFilter.setAuthenticationManager(authManager);
        return usernamePasswordAuthProccessingFilter;
    }
    
    @Autowired
    public void registerProvider(AuthenticationManagerBuilder authManagerBuilder){
        authManagerBuilder.authenticationProvider(usernamePasswordAuthProvider);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity,@Autowired UsernamePasswordAuthProccessingFilter usernamePasswordAuthProccessingFilter) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize) -> {
            try {
                authorize.and().csrf(cs -> {
                    cs.disable();
                }).authorizeHttpRequests().anyRequest().authenticated()
                .and().sessionManagement(sessionManager -> {
                    sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                });
            
                authorize.and().addFilterBefore(usernamePasswordAuthProccessingFilter, UsernamePasswordAuthenticationFilter.class);
            } catch (Exception exception) {
                log.info("\n");
                log.error("ERROR {}", exception.getMessage());
                log.info("\n");
            }
        });
        return httpSecurity.build();
    }
}












