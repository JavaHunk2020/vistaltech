package com.boot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

	//<form action="cauth" method="get">
	@GetMapping("/cauth")
	public String showAuthJsp() {
		return "auth";  // auth.jsp
	}
	
	
	//<form action="cauth" method="post">
	@PostMapping("/cauth")
	public String postAuth(@RequestParam String email,@RequestParam String ppassword,Model model) {
		if("jack@gmail.com".equalsIgnoreCase(email) && "jill".equalsIgnoreCase(ppassword)) {
			model.addAttribute("message", "Hey! username and password are correct!");
			return "home";  // home.jsp
		}else {
			model.addAttribute("message", "Sorry! username and password are not correct!");
			return "auth";  // auth.jsp
		}
		
	}
}
