package com.boot.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.boot.dao.PeopleRepository;
import com.boot.entity.People;
import com.boot.model.PeopleDTO;

@Service
public class PeopleService {
	
	final private PeopleRepository peopleRepository;
	
	public PeopleService(PeopleRepository peopleRepository){
		this.peopleRepository=peopleRepository;
	}
	
	public void save(PeopleDTO peopleDTO) {
		 System.out.println("service = "+peopleDTO);
		 People people=new People();
		 BeanUtils.copyProperties(peopleDTO, people);
		 peopleRepository.save(people);
	}

}
