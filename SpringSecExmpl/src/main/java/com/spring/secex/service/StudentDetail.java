package com.spring.secex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.secex.dao.RepositoryIntrfc;
import com.spring.secex.model.Student;

@Service
public class StudentDetail implements StudentService {
	
	@Autowired
	RepositoryIntrfc repo;
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	public Student saveStudent(Student student) {
		student.setPassword(encoder.encode(student.getPassword()));
		return repo.save(student);
	}
	public List<Student> findAll() {
		return repo.findAll();
	}
	public Student findById(Long id) {
		return repo.findById(id).get();
	}
	
}
