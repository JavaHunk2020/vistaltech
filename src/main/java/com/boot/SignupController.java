package com.boot;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SignupController {
	
	@Autowired
	private EmployeeService employeeService;

	//<form action="cauth" method="get">
	@GetMapping("/signup")
	public String showSignup() {
		return "signup";  // signup.jsp
	}
	
	@PostMapping("/signup")
	public String postMapping(@ModelAttribute Employee employee,Model model) {
		employeeService.addEmployee(employee);
		model.addAttribute("message","Hey! registration is done");
		return "auth";  // auth.jsp
	}
	
	

	@GetMapping("/deleteEmployee")
	public String deleteEmployee(@RequestParam String email,Model model) {
		employeeService.deleteByEmail(email);
		List<Employee> employees=employeeService.findEmployees();
		//adding into request scope
		model.addAttribute("message", "Employee is deleted successfully email = "+email);
		model.addAttribute("employees", employees);
		return "home";  // auth.jsp
	}
	
}
