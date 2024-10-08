package com.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.boot.util.RandomPasswordGenerator;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private EmployeeService employeeService;

	@Async
	public void send(String email) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("omega@gmail.com");
		message.setTo(email);
		message.setSubject("Regarding new password reset!!!!!!!!!!!!!");
		String password = RandomPasswordGenerator.generateRandomPassword();
		employeeService.resetPasswordByEmail(email, password);
		message.setText("Hey your name password is  = " + password);
		mailSender.send(message);
		System.out.println("Mail sent successfully...");
	}

}
