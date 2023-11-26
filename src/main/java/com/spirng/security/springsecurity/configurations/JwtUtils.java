package com.spirng.security.springsecurity.configurations;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
    
    private String jwtStringKey = "87587aa8-e04a-443c-9011-516c226929ed";

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    
    public Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(jwtStringKey).parseClaimsJws(token).getBody();
    }
    
    public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    public java.util.Date extractExpiration(String token) {
       return extractClaim(token, Claims::getExpiration);
    }

    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new java.util.Date());
    }

    public Boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String generateToken(Map<String, Object> claims, UserDetails userDetails) {
        return createToken(claims, userDetails);
    }

    private String createToken(Map<String, Object> claims, UserDetails userDetails) {
        return Jwts.builder()
            .setSubject(userDetails.getUsername())
            .claim("authorities", userDetails.getAuthorities())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(24)))
            .signWith(SignatureAlgorithm.HS256, jwtStringKey)
            .compact();
    }
}