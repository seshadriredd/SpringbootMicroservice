package com.spring.secex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.secex.dao.UserRepository;
import com.spring.secex.jwt.JwtService;
import com.spring.secex.model.AuthUser;
import com.spring.secex.model.Users;
import com.spring.secex.service.UserRepoService;


@RestController
class UserController {
	
	@Autowired
	UserRepository repo;
	@Autowired
	UserRepoService userRepoService;
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	@Autowired
	AuthenticationManager authenticationManager;
	@Autowired
	JwtService jwtService;
	@PostMapping("/addUser")
	public ResponseEntity<Users> addrole(@RequestBody Users user){
		user.setPassword(encoder.encode(user.getPassword()));
		return new ResponseEntity<Users>(userRepoService.addUser(user),HttpStatus.CREATED);
	}
	String token;
	@PostMapping("/authUser")
	public ResponseEntity<String> getToken(@RequestBody AuthUser authUser){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authUser.getUsername(), authUser.getPassword()));
		if(authentication.isAuthenticated()) {
			token =jwtService.generateToken(authUser);
		}
		return new ResponseEntity<String>(token,HttpStatus.OK);
		
	}
}
