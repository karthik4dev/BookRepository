package com.karthikProject.Authserver.Service;


import io.jsonwebtoken.Jwts;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;


import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JWTService {

    public static final byte[] keyBytes = Jwts.SIG.HS256.key().build().getEncoded();


    public void validateToken(final String token) {
         Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token);
    }


    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userName);
    }

    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .claims(claims)
                .subject(userName)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(getSignKey(),Jwts.SIG.HS256).compact();
    }

    private SecretKey getSignKey() {
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
