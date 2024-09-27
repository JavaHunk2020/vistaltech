package com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.p1.SaiService;
import com.p2.NotificationService;

public class Main2 {
	
	public static void main(String[] args) {
		/*
		 * NotificationService notificationService=new NotificationService();
		 * notificationService.send("How are you?");
		 */
		//How to create spring container
		 //<bean id="notificationService" class="com.service.NotificationService" >
	      // <property name="email" value="vistaltech@gmail.com"/>
	   //</bean>  
		ApplicationContext ac =new AnnotationConfigApplicationContext(SpringConfig.class);
		NotificationService notificationService=(NotificationService)ac.getBean("notificationService");
		notificationService.send("How are you?");
		
		SaiService saiService1=ac.getBean(SaiService.class);
		saiService1.run();
		SaiService saiService2=ac.getBean(SaiService.class);
		saiService2.run();
		
		if(saiService1==saiService2) {
			System.out.println("Default scope is singleton");
		}else {
			System.out.println("Now scope is prototype");
		}
	}

}
