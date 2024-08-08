package com.spring.secex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.secex.dao.UserRepository;
import com.spring.secex.model.Users;

@RestController
public class UserController {
	
	@Autowired
	UserRepository repo;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@PostMapping("/addUser")
	public ResponseEntity<Users> addrole(@RequestBody Users user){
		//user.setPassword(encoder.encode(user.getPassword()));
		return new ResponseEntity<Users>(repo.save(user),HttpStatus.CREATED);
	}
}
