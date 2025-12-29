package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    private static final String SECRET_KEY =
            "demo-secret-key-123456-demo-secret-key";

    private static final long EXPIRATION_MILLIS =
            24 * 60 * 60 * 1000;

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(
                SECRET_KEY.getBytes(StandardCharsets.UTF_8)
        );
    }

    public String generateToken(Long userId, String email, String role) {

        Date now = new Date();
        Date expiry = new Date(now.getTime() + EXPIRATION_MILLIS);

        return Jwts.builder()
                .setSubject(email)
                .claim("userId", userId)
                .claim("role", role)
                .setIssuedAt(now)
                .setExpiration(expiry)
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) 
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()                    
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException ex) {
            return false;
        }
    }

    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder()                // ✅ FIX
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
