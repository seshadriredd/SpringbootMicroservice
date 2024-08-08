package com.spring.secex.service;

import java.util.List;

import com.spring.secex.model.Student;

public interface StudentService {
	public Student saveStudent(Student student);
	public List<Student> findAll();
	public Student findById(Long id);
}
