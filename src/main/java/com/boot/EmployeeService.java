package com.boot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	private  List<Employee> employees=new ArrayList<Employee>();
	
	@PostConstruct
	public void initialize() {
		Employee employee1=new Employee("Abhay", "Singh","abhay@gmail.com");
		Employee employee2=new Employee("Jhon", "Singh2","aewqy@gmail.com");
		Employee employee3=new Employee("Abhay2", "Singh4","ewa@gmail.com");
		Employee employee4=new Employee("Abhay3", "Singh5","ads@gmail.com");
		Employee employee5=new Employee("Abhay4", "Singh3","jock@gmail.com");
		Employee employee6=new Employee("Abhay5", "Singh5","abwqy@gmail.com");
		Employee employee7=new Employee("Abhay6", "Singh6","abhaewq@gmail.com");
		
		employees.add(employee7);
		employees.add(employee5);
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		employees.add(employee4);
		employees.add(employee6);
	}
	
	public  void deleteByEmail(String email) {
		Iterator<Employee> iterator=employees.iterator();
		while(iterator.hasNext()) {
			Employee emp=iterator.next();
			if(emp.getEmail().equalsIgnoreCase(email)) {
				iterator.remove();
			}
		}
	}
	
	public  void addEmployee(Employee employee ) {
		employees.add(employee);
	}
	
	public  List<Employee> findEmployees(){
		 return employees;
	}

}
