package com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.p1.SaiService;
import com.p2.NotificationService;
import com.pizza.PizzaService;

public class Main3 {
	
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
		PizzaService pizzaService=ac.getBean(PizzaService.class);
		pizzaService.magic();
	}

}
