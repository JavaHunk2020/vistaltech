package com.boot.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.boot.entity.Employee;
import com.boot.entity.LoginHistory;

@Repository
public interface LoginHistoryRepository  extends JpaRepository<LoginHistory, Long> {
	

}
