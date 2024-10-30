package com.boot.advice;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(EmployeeNotFoundExeception.class)
	public String handleException(EmployeeNotFoundExeception ex,Model model) {
		model.addAttribute("errorMessage", ex.getMessage());
		return "block";
	}
	
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex,Model model) {
		model.addAttribute("errorMessage", ex.getMessage());
		return "block";
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public @ResponseBody ResponseEntity<Map<String,Object>>  handleException(AccessDeniedException ex,Model model) {
		return new ResponseEntity<>(Map.of("message", "How dare you to access this resource"), HttpStatus.FORBIDDEN);
	}
	
}
