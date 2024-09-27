package com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.p2.NotificationService;

public class Main1 {
	
	public static void main(String[] args) {
		/*
		 * NotificationService notificationService=new NotificationService();
		 * notificationService.send("How are you?");
		 */
		ApplicationContext ac =new ClassPathXmlApplicationContext("aemail-service.xml");
		NotificationService notificationService=(NotificationService)ac.getBean("notificationService");
		notificationService.send("How are you?");
	}

}
