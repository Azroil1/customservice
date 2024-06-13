package ru.mtsbank.customservice.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.mtsbank.customservice.userdetail.CustomerUserDetail;

import javax.annotation.PostConstruct;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.secret}")
    private String secretKey;
    SecretKey key;

    @PostConstruct
    public void init(){
        byte[] decode = Base64.getDecoder().decode(secretKey);
        this.key = new SecretKeySpec(decode, 0,decode.length,"HmacSHA256");
    }

    public String getToken(CustomerUserDetail userDetail) {
        return Jwts.builder()
                .claim("bankAccountId", userDetail.getBankAccountId())
                .claim("customerAccountId", userDetail.getCustomerId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000*60*100))
                .signWith(key)
                .compact();
    }
}
