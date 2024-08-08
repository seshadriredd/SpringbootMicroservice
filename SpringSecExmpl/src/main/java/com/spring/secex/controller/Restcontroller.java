package com.spring.secex.controller;

import java.util.List;

import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.secex.model.Student;
import com.spring.secex.service.StudentDetail;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class Restcontroller {
	
	@Autowired
	StudentDetail studtl;
	
	@GetMapping("/status")
	public ResponseEntity<String> status(HttpServletRequest request) {
		System.out.println("Inside the status");
		return new ResponseEntity<String>("I am available ::"+request.getSession().getId(),HttpStatus.OK);
	}
	@PostMapping("/admin/add")
	public ResponseEntity<Student> add(@RequestBody Student student, HttpServletRequest request) {
		System.out.println("Inside the admin/add");
		return new ResponseEntity<Student>(studtl.saveStudent(student),HttpStatus.CREATED);
	}
	@GetMapping("/csrf")
	public CsrfToken csrftoken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf") ;
		
	}
	@GetMapping("/user/id/{id}")
	public ResponseEntity<Student> getAll(@PathVariable Long id) {
		System.out.println("Inside the user/id");
		return new ResponseEntity<Student>(studtl.findById(id),HttpStatus.OK);
		
	}
	@GetMapping("/gm/all")
	public ResponseEntity<List<Student>> getAll() {
		System.out.println("Inside the GM/all");
		return new ResponseEntity<List<Student>>(studtl.findAll(),HttpStatus.OK);
		
	}
}
