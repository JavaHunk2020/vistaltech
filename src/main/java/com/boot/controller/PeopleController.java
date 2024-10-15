package com.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.boot.model.PeopleDTO;
import com.boot.service.PeopleService;

//Request Header
//Request Body
@Controller
public class PeopleController {
	
	@Autowired
	private PeopleService peopleService;
	
	@GetMapping("/people")
	public String showPeople() {
		return "people";
	}
	
	
	@PostMapping("/people")
	public String postPeople(@ModelAttribute PeopleDTO peopleDTO,Model model) {
		System.out.println(peopleDTO);
		peopleService.save(peopleDTO);
		model.addAttribute("message", "Data is submitted here!!!!!!!");
		return "people";
	}

}
