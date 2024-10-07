package com.boot.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boot.entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {
	
	@Modifying
	@Transactional
	public void deleteByEmail(String email);
	
	public Optional<Employee> findByEmail(String email);
	
	boolean existsByEmail(String email);

}
