package com.boot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entity.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {

}
