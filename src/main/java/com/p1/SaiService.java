package com.p1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SaiService {
	
	
	String color="white";
	
	public void run() {
		System.out.println("I am running = "+color);
	}

}
