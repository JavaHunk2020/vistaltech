package com.boot.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entity.Employee;
import com.boot.entity.EmployeeRepository;
import com.boot.model.EmployeeDTO;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	private  List<EmployeeDTO> employees=new ArrayList<EmployeeDTO>();
	
	@PostConstruct
	public void initialize() {
		EmployeeDTO employee1=new EmployeeDTO("Abhay", "Singh","abhay@gmail.com");
		EmployeeDTO employee2=new EmployeeDTO("Jhon", "Singh2","aewqy@gmail.com");
		EmployeeDTO employee3=new EmployeeDTO("Abhay2", "Singh4","ewa@gmail.com");
		EmployeeDTO employee4=new EmployeeDTO("Abhay3", "Singh5","ads@gmail.com");
		EmployeeDTO employee5=new EmployeeDTO("Abhay4", "Singh3","jock@gmail.com");
		EmployeeDTO employee6=new EmployeeDTO("Abhay5", "Singh5","abwqy@gmail.com");
		EmployeeDTO employee7=new EmployeeDTO("Abhay6", "Singh6","abhaewq@gmail.com");
		
		employees.add(employee7);
		employees.add(employee5);
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee6);
	}
	
	public  void deleteByEmail(String email) {
		Iterator<EmployeeDTO> iterator=employees.iterator();
		while(iterator.hasNext()) {
			EmployeeDTO emp=iterator.next();
			if(emp.getEmail().equalsIgnoreCase(email)) {
				iterator.remove();
			}
		}
	}
	
	public  EmployeeDTO findEmployeeByEmail(String email){
		Iterator<EmployeeDTO> iterator=employees.iterator();
		while(iterator.hasNext()) {
			EmployeeDTO emp=iterator.next();
			if(emp.getEmail().equalsIgnoreCase(email)) {
				return emp;
			}
		}
		return null;
	}
	
	public  void addEmployee(EmployeeDTO employee ) {
		//employees.add(employee);
		
		Employee entity=new Employee();
		BeanUtils.copyProperties(employee, entity);
		employeeRepository.save(entity);
		
	}
	
	public  List<EmployeeDTO> findEmployees(){
		 //FETCHING FROM DATA BASE
		 List<Employee> employeeEntitList=employeeRepository.findAll();
		 List<EmployeeDTO>  employeeDTOs=new ArrayList<EmployeeDTO>();
		 for(Employee entity : employeeEntitList) {
			 EmployeeDTO dto=new EmployeeDTO();
			 BeanUtils.copyProperties(entity, dto);
			 employeeDTOs.add(dto);
		 }
		 
		 employees.addAll(employeeDTOs);
		 return employees;
	}
	
	public  void updateEmployee(EmployeeDTO employee){
		Iterator<EmployeeDTO> iterator=employees.iterator();
		while(iterator.hasNext()) {
			EmployeeDTO emp=iterator.next();
			if(emp.getEmail().equalsIgnoreCase(employee.getEmail())) {
				iterator.remove();
				break;
			}
		}
		employees.add(employee);
	}
}
