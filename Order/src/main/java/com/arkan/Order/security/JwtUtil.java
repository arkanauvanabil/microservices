package com.arkan.Order.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String extractUsername(String token) {

        try {
            // 🔥 ambil hanya header + payload (buang signature)
            String[] parts = token.split("\\.");
            if (parts.length < 2) return null;

            String unsignedToken = parts[0] + "." + parts[1] + ".";

            Claims claims = Jwts.parserBuilder()
                    .build()
                    .parseClaimsJwt(unsignedToken)
                    .getBody();

            return claims.getSubject();

        } catch (Exception e) {
            System.out.println("ERROR JWT: " + e.getMessage());
            return null;
        }
    }
}