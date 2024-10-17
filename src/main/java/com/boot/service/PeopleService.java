package com.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.boot.advice.ResourceNotFoundExeception;
import com.boot.dao.PeopleRepository;
import com.boot.entity.People;
import com.boot.model.PeopleDTO;

@Service
@Scope("singleton")
public class PeopleService {
	
	final private PeopleRepository peopleRepository;
	
	public PeopleService(PeopleRepository peopleRepository){
		this.peopleRepository=peopleRepository;
	}
	
	public PeopleDTO findById(long pid) {
		People people=peopleRepository.findById(pid).
				orElseThrow(()->new ResourceNotFoundExeception("Hey this people does not exist"));
		PeopleDTO peopleDTO=new PeopleDTO();
		BeanUtils.copyProperties(people, peopleDTO);
		return peopleDTO;
	}
	
	public List<PeopleDTO> findAll() {
		 List<People>  peoples=peopleRepository.findAll();
		 List<PeopleDTO> list=new ArrayList<PeopleDTO>();
		 for(People people : peoples) {
			 PeopleDTO dto=new PeopleDTO();
			 BeanUtils.copyProperties(people, dto);
			 list.add(dto);
		 }
		 return list;
	}
	
	public void save(PeopleDTO peopleDTO) {
		 System.out.println("service = "+peopleDTO);
		 People people=new People();
		 BeanUtils.copyProperties(peopleDTO, people);
		 peopleRepository.save(people);
	}

	public void deleteById(long pid) {
		peopleRepository.deleteById(pid);
	}

}
