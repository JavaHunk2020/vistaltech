package com.boot.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.EmployeeDTO;
import com.boot.model.LoginDTO;
import com.boot.service.EmployeeService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/v1")
public class LoginRestController {

	
	@Value("${jwt.secret.key:ABUE87%&$&##@)@(&@*^@^@@@}")
	private String jwtSecret;


	private int jwtExpirationMs = 1800000;
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/user/login")
	public ResponseEntity<Map<String,Object>> authUser(@RequestBody  EmployeeDTO employee) {
		 System.out.println("________________"+employee);
		 try {
		 EmployeeDTO employeeDTO=employeeService.findEmployeeByEmail(employee.getEmail());
		  if(employeeDTO.getPassword().equalsIgnoreCase(employee.getPassword())) {
			  return new ResponseEntity<Map<String,Object>>(Map.of("message","login is done!!"),HttpStatus.OK);	  
		  }
		 }catch (Exception e) {
			 	System.out.println(e.getMessage());
		 }
	  return new ResponseEntity<Map<String,Object>>(Map.of("message","login is failed!!"),HttpStatus.UNAUTHORIZED);	  
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/signups/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable long id) {
		 employeeService.deleteById(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	//access-control-allow-origin:
	//http://localhost:4200
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/signups")
	public ResponseEntity<List<EmployeeDTO>> showAll() {
         return new ResponseEntity<>(employeeService.findEmployees(),HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/signup")
	public ResponseEntity<Map<String,Object>> postMapping(@RequestBody  EmployeeDTO employee) {
		 System.out.println("________________"+employee);
         long id=employeeService.addEmployee(employee);
         return new ResponseEntity<Map<String,Object>>(Map.of("message","Signup is done!!","id",id),HttpStatus.CREATED);
	}
	
	
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
