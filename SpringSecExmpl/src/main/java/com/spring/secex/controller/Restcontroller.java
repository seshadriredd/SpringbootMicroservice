package com.spring.secex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class Restcontroller {
	@GetMapping("/status")
	public ResponseEntity<String> status(HttpServletRequest request) {
		return new ResponseEntity<String>("I am available ::"+request.getSession().getId(),HttpStatus.OK);
	}
	@PostMapping("/add")
	public ResponseEntity<String> add(HttpServletRequest request) {
		return new ResponseEntity<String>("Record added successfully ::"+request.getSession().getId(),HttpStatus.OK);
	}
	@GetMapping("/csrf")
	public CsrfToken csrftoken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf") ;
		
	}
}
