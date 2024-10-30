package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.PeopleDTO;
import com.boot.service.PeopleService;

//POST , PUT , PATCH
//@RestController =>>  @Controller +@ResponseBody
@RestController
@RequestMapping("/v1")
public class PeopleRestContoller {
    
	@Autowired
	private PeopleService peopleService;
	
	
	@PutMapping("/peoples")
	public ResponseEntity<PeopleDTO> updatePeoples(@RequestBody PeopleDTO peopleDTO){
		 PeopleDTO rpeopleDTO=peopleService.update(peopleDTO);
		 return new ResponseEntity<>(rpeopleDTO,HttpStatus.OK);
	}
	
	@PostMapping("/peoples")
	public ResponseEntity<PeopleDTO> postPeoples(@RequestBody PeopleDTO peopleDTO){
		 PeopleDTO rpeopleDTO=peopleService.ssave(peopleDTO);
		 return new ResponseEntity<>(rpeopleDTO,HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping("/peoples/{pid}")
	public ResponseEntity<Void> deletePeople(@PathVariable long pid){
         peopleService.deleteById(pid);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	///peoples/1
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/peoples/{pid}")
	public ResponseEntity<PeopleDTO> getPeople(@PathVariable long pid){
		PeopleDTO peopleDTO=peopleService.findById(pid);
			return new ResponseEntity<>(peopleDTO,HttpStatus.OK);
	}
	
	//Every method in rest api is known as resource
	//it must mapped with unique
	
	//URL - URI
	//http://localhost:333/v1/peoples
	@GetMapping("/peoples")
	public ResponseEntity<List<PeopleDTO>> getPeoples(){
		List<PeopleDTO> peopleDTOs=peopleService.findAll();
		if(peopleDTOs.size()==0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<>(peopleDTOs,HttpStatus.OK);
		}
	}
}
