package com.spring.secex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.secex.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class Restcontroller {
	
	private Student obj = new Student();
	@GetMapping("/status")
	public ResponseEntity<String> status(HttpServletRequest request) {
		return new ResponseEntity<String>("I am available ::"+request.getSession().getId(),HttpStatus.OK);
	}
	@PostMapping("/admin/add")
	public ResponseEntity<Student> add(@RequestBody Student student, HttpServletRequest request) {
		obj.setId(student.getId());
		obj.setGrade(student.getGrade());
		obj.setName(student.getName());
		obj.setGuardian(student.getGuardian());
		return new ResponseEntity<Student>(obj,HttpStatus.OK);
	}
	@GetMapping("/csrf")
	public CsrfToken csrftoken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf") ;
		
	}
	@GetMapping("/all")
	public ResponseEntity<Student> getAll() {
		return new ResponseEntity<Student>(obj,HttpStatus.OK);
		
	}
}
