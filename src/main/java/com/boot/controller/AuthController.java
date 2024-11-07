package com.boot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.model.EmployeeDTO;
import com.boot.service.EmailService;
import com.boot.service.EmployeeService;
import com.boot.util.RandomPasswordGenerator;

@Controller
public class AuthController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmailService emailService;
	
	

	// <form action="cauth" method="get">
	@GetMapping({"/cauth","/"})
	public String showAuthJsp(@RequestParam(required = false) String logout,HttpSession session,Model model) {
		if(logout!=null && session!=null && session.getAttribute("llr")!=null) {
			long llr=(Long)session.getAttribute("llr");
			employeeService.updateLogoutTime(llr);
			session.invalidate();
		}
		model.addAttribute("message", "You have logged out successfully!");
		return "auth"; // auth.jsp
	}
	
	
	@PostMapping("/passwordReset")
	public String sendPasswordResetLInk(@RequestParam String email) {
		    //WHEN YOU CALL IT+ >> DO YOU THINK YOU WOULD BE BLOCKED
		    emailService.send(email);
		    return "auth";
	}	

	@PostMapping("/cauth")
	public String postAuth(@RequestParam String email, @RequestParam String ppassword,HttpSession session, Model model) {
		if (!validateEmail(email)) {
			model.addAttribute("message", "Hey your email is not valid!");
			return "auth";
		}
		EmployeeDTO employee = new EmployeeDTO(email, ppassword);
		boolean status=employeeService.findEmployees().contains(employee);
		if (status) {
			long llr=employeeService.saveLogin(email);
			session.setAttribute("llr", llr);
			session.setAttribute("email", email);
			model.addAttribute("message", "User is there, Thank you!");
			// I am setting this messasge inside request scope
			// so that I can pick it on jsp
			// loading employee
			List<EmployeeDTO> employees = employeeService.findEmployees();
			// adding into request scope
			model.addAttribute("employees", employees);
			return "home";
		} else {
			model.addAttribute("message", "User is not there, Sorry!!");
			// I am setting this messasge inside request scope
			// so that I can pick it on jsp
			return "auth";
		}
	}


	private boolean validateEmail(String input) {
		return input.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
	}

}
