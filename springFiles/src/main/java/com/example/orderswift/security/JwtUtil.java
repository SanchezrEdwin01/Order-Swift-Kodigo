package com.example.orderswift.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
@Component
public class JwtUtil {


        private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        private final String ISSUER = "orderswift";

        public String generateToken(String username, String role) {
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + 3600000); // token will expire in 1 hour
            return Jwts.builder()
                    .setSubject(username)
                    .setIssuer(ISSUER)
                    .claim("role", role)
                    .setIssuedAt(now)
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS256,key)
                    .compact();
        }

        public Claims parseToken(String token) {
            return Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(token)
                    .getBody();
        }

}
