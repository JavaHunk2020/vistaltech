package com.pizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.p1.SaiService;

@Repository
public class PizzaService {
	
	@Autowired
	private SaiService saiService;
	
	public void magic() {
		System.out.println("Magic is calling saiService");
		saiService.run();
	}

}
