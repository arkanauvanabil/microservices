package com.arkan.authservic.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .claim("role", "USER")
                .setIssuedAt(new Date())
                .compact(); // ❌ TANPA sign
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .build()
                .parseClaimsJwt(token) // ❌ TANPA verify
                .getBody()
                .getSubject();
    }
}