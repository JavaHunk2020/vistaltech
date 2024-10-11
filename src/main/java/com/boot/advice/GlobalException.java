package com.boot.advice;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

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
}
