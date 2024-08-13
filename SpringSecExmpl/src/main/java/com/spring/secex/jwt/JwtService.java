package com.spring.secex.jwt;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;

import com.spring.secex.model.AuthUser;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	private String secretKey = null;
	Map<String,String> claims = new HashMap<>();  
	public JwtService() throws NoSuchAlgorithmException {
		KeyGenerator keyGen =KeyGenerator.getInstance("HmacSHA256");
		SecretKey seckey = keyGen.generateKey();
		secretKey = Base64.getEncoder().encodeToString(seckey.getEncoded());
	}
	public String generateToken(AuthUser user) {
		claims.put("name", "seshadri");
		return Jwts.builder()
			.claims(claims)
			.subject(user.getUsername())
			.issuedAt(Date.from(Instant.now()))
			.expiration(Date.from(Instant.now().plusMillis(200000)))
			.signWith(getkey())
			.compact();
	}
	private SecretKey getkey() {
		
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
	}

}
