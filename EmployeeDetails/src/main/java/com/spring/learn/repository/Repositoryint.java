package com.spring.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.learn.entity.Employee;

public interface Repositoryint extends JpaRepository<Employee, Long> {
	
}
