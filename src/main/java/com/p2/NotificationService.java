package com.p2;

import org.springframework.stereotype.Service;

//@Controller , @Component , @Repository
//   <bean id="notificationService" class="com.service.NotificationService" >
//<property name="email" value="vistaltech@gmail.com"/>
//</bean>    
@Service("notificationService")
public class NotificationService {
	
	private String email="nagen@gmail.com";
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void send(String message) {
		System.out.println("send message = "+message +" to "+email);
	}

}
