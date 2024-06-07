package ru.mtsbank.customservice.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import ru.mtsbank.customservice.userdetail.CustomerUserDetail;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {
    SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    public String getToken(CustomerUserDetail userDetail) {
        return Jwts.builder()
                .setSubject(userDetail.getUsername())
                .claim("bankAccountId", userDetail.getBankAccountId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*10))
                .signWith(key)
                .compact();
    }
}
