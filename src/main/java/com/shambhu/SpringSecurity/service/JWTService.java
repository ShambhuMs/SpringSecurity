package com.shambhu.SpringSecurity.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class JWTService {
    private String key;

    public JWTService() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator=KeyGenerator.getInstance("HmacSHA256");
        SecretKey secretKey= keyGenerator.generateKey();
        key= Base64.getEncoder().encodeToString(secretKey.getEncoded());
    }

    Map<String, Objects> claimRef=new HashMap<>();
    public String generateToken(String username) {
        return Jwts.builder()
                .claims()
                .add(claimRef)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+60*60*30))
                .and()
                .signWith(getKey())
                .compact();
    }

    private Key getKey() {
        byte[] byteKey= Decoders.BASE64.decode(key);
        return Keys.hmacShaKeyFor(byteKey);
    }
}
