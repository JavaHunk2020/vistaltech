package com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.p2.NotificationService;

public class Main {
	
	public static void main(String[] args) {
		/*
		 * NotificationService notificationService=new NotificationService();
		 * notificationService.send("How are you?");
		 */
		//How to create spring container
		 //<bean id="notificationService" class="com.service.NotificationService" >
	      // <property name="email" value="vistaltech@gmail.com"/>
	   //</bean>  
		ApplicationContext ac =new ClassPathXmlApplicationContext("email-service.xml");
		NotificationService notificationService=(NotificationService)ac.getBean("notificationService");
		notificationService.send("How are you?");
	}

}
