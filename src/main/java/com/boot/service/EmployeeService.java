package com.boot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.advice.EmployeeNotFoundExeception;
import com.boot.dao.EmployeeRepository;
import com.boot.entity.Employee;
import com.boot.model.EmployeeDTO;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public  void deleteByEmail(String email) {
		employeeRepository.deleteByEmail(email);
	}
	
	public  EmployeeDTO findEmployeeByEmail(String email){
		Optional<Employee> optional=employeeRepository.findByEmail(email);
		if(optional.isPresent()) {
			EmployeeDTO employeeDTO=new EmployeeDTO();
			BeanUtils.copyProperties(optional.get(), employeeDTO);
			return employeeDTO;
		}else {
			throw new EmployeeNotFoundExeception("It seems like , this employee does not exist.");
		}
	}
	
	/**
	 *  This method is adding data inside database
	 * @param employee
	 */
	public  void addEmployee(EmployeeDTO employee ) {
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
		 return employeeDTOs;
	}
	
	public  void updateEmployee(EmployeeDTO employee){
		Employee  dbEmployee=employeeRepository.findByEmail(employee.getEmail()).get();
		if(employee.getFirstName()!=null) {
			dbEmployee.setFirstName(employee.getFirstName());
		}
		if(employee.getLastName()!=null) {
			dbEmployee.setLastName(employee.getLastName());
		}
		if(employee.getPassword()!=null) {
			dbEmployee.setPassword(employee.getPassword());
		}
		employeeRepository.save(dbEmployee);
	}
}
