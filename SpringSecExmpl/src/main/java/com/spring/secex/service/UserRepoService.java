package com.spring.secex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.secex.dao.UserRepository;
import com.spring.secex.model.Users;

@Service
public class UserRepoService {
	@Autowired
	UserRepository repo;
	public Users addUser(Users user) {
		return repo.save(user);
		
	}
	
}
