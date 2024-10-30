package com.boot.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.LoginDTO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/v1")
public class LoginRestController {

	
	@Value("${jwt.secret.key:ABUE87%&$&##@)@(&@*^@^@@@}")
	private String jwtSecret;

	private int jwtExpirationMs = 1800000;
	
	@PostMapping("/slogin")
	public ResponseEntity<Map<String,Object>> authAndGenToken(@RequestBody LoginDTO loginDTO){
		Map<String,Object> map=new HashMap<String, Object>();
		if(loginDTO.getUsername().equalsIgnoreCase("jack@gmail.com") && loginDTO.getPassword().equalsIgnoreCase("jill")) {
			Map<String, Object> claims = new HashMap<>();
			claims.put("company", "AbcTech");
			claims.put("Issuer", "agora.com");
			claims.put("scopes", List.of("ADMIN"));
			String token= Jwts.builder().
					setSubject(loginDTO.getUsername())
					.addClaims(claims)
					.setIssuedAt(new Date())
					.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
					.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
			return new ResponseEntity<Map<String,Object>>(Map.of("Authorization",token,"username",loginDTO.getUsername()),HttpStatus.UNAUTHORIZED);
		}else if(loginDTO.getUsername().equalsIgnoreCase("mack@gmail.com") && loginDTO.getPassword().equalsIgnoreCase("test")) {
			Map<String, Object> claims = new HashMap<>();
			claims.put("company", "AbcTech");
			claims.put("Issuer", "agora.com");
			claims.put("scopes", List.of("CUSTOMER"));
			String token= Jwts.builder().
					setSubject(loginDTO.getUsername())
					.addClaims(claims)
					.setIssuedAt(new Date())
					.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
					.signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
			return new ResponseEntity<Map<String,Object>>(Map.of("Authorization",token,"username",loginDTO.getUsername()),HttpStatus.UNAUTHORIZED);
		}else {
			return new ResponseEntity<Map<String,Object>>(Map.of("message","Username and password are not currect"),HttpStatus.UNAUTHORIZED);
		}
	}
	
	
}
