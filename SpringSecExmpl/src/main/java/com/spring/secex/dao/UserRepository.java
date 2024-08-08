package com.spring.secex.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.secex.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

	public Users findByUsername(String username);
	
}
