package com.boot.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boot.advice.EmployeeNotFoundExeception;
import com.boot.dao.EmployeeRepository;
import com.boot.dao.LoginHistoryRepository;
import com.boot.entity.Employee;
import com.boot.entity.LoginHistory;
import com.boot.model.EmployeeDTO;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private LoginHistoryRepository loginHistoryRepository;
	
	public  byte[] findPhotoByEmail(String email) {
		Optional<Employee> optional=employeeRepository.findByEmail(email);
		if(optional.isPresent()) {
			return optional.get().getPhoto();
		}else {
			throw new EmployeeNotFoundExeception("It seems like , this employee does not exist.");
		}
	}
	
	@Transactional
	public  void resetPasswordByEmail(String email,String password){
		Optional<Employee> optional=employeeRepository.findByEmail(email);
		if(optional.isPresent()) {
			Employee employee=optional.get();
			employee.setPassword(password);
		}else {
			throw new EmployeeNotFoundExeception("It seems like , this employee does not exist.");
		}
	}
	
	@Transactional
	public  void updateLogoutTime(long llr) {
		LoginHistory history=loginHistoryRepository.findById(llr).get();
		history.setLogoutTime(new Timestamp(new Date().getTime()));
	}
	
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
	public  boolean addEmployee(EmployeeDTO employee ) {
		Optional<Employee> optional=employeeRepository.findByEmail(employee.getEmail());
		if(optional.isPresent()) {
			return false;
		}
		Employee entity=new Employee();
		BeanUtils.copyProperties(employee, entity,new String[] {"photo"});
		try {
			entity.setPhoto(employee.getPhoto().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		employeeRepository.save(entity);
		return true;
	}
	
	
	public  List<EmployeeDTO> findEmployeesSortByEmail(String name,String orderBy){
		 //FETCHING FROM DATA BASE
		 // Determine sort direction (ascending or descending)
        Sort.Direction direction = Sort.Direction.fromString(orderBy);
        // Create a Sort object based on the sortBy field and sortDirection
        Sort sort = Sort.by(direction, name);
		 List<Employee> employeeEntitList=employeeRepository.findAll(sort);
		 List<EmployeeDTO>  employeeDTOs=new ArrayList<EmployeeDTO>();
		 for(Employee entity : employeeEntitList) {
			 EmployeeDTO dto=new EmployeeDTO();
			 BeanUtils.copyProperties(entity, dto);
			 employeeDTOs.add(dto);
		 }
		 return employeeDTOs;
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
		if(employee.getPhoto()!=null && employee.getPhoto().getSize()>0) {
			try {
				dbEmployee.setPhoto(employee.getPhoto().getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		employeeRepository.save(dbEmployee);
	}
	
	public long saveLogin(String email) {
		Employee  dbEmployee=employeeRepository.findByEmail(email).get();
		LoginHistory history=new LoginHistory();
		history.setEmployee(dbEmployee);
		history.setLoginTime(new Timestamp(new Date().getTime()));
		LoginHistory phistory=loginHistoryRepository.save(history);
		return phistory.getId();
	}
}
