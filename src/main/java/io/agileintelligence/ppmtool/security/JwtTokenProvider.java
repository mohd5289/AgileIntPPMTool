package io.agileintelligence.ppmtool.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.agileintelligence.ppmtool.domain.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import static io.agileintelligence.ppmtool.security.SecurityConstants.*;

@Component
public class JwtTokenProvider {




public String generateToken(Authentication authentication) {
	User user=  (User) authentication.getPrincipal();
	
	Date now = new Date(System.currentTimeMillis());
	
	Date expiryDate = new Date(now.getTime()+EXPIRATION_TIME);

  String userId = Long.toString(user.getId());
  
  Map<String,Object> claims = new HashMap<>();
  claims.put("id", Long.toString(user.getId()));
  claims.put("username", user.getUsername());
  claims.put("fullName", user.getFullname());
  
  
  return Jwts.builder()
		  .setSubject(userId)
		  .setClaims(claims)
		  .setIssuedAt(now)
		  .setExpiration(expiryDate)
		  .signWith(SignatureAlgorithm.HS512, SECRET)
		  .compact();

}
public boolean validateToken(String token) {
	try {
		Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
		return true;
	}catch(SignatureException ex) {
		System.out.print("Invalid JWT Signature");
	}catch(MalformedJwtException ex) {
		System.out.print("Invalid JWT Token");
	}catch(ExpiredJwtException ex) {
		System.out.print("Expired JWT Token");	
	}catch(UnsupportedJwtException ex) {
		System.out.print("Invalid JWT Token");
		
	}catch(IllegalArgumentException ex) {
		System.out.print("Unsupported JWT Token");
		
	}
	return false;
	
	
}



public long getUserIdfromJWT(String token) {
	Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
	
	String id =(String)claims.get("id");
	
	return Long.parseLong(id);	
}



}
