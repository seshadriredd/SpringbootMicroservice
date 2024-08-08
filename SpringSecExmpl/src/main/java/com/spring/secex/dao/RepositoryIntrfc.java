package com.spring.secex.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.secex.model.Student;

public interface RepositoryIntrfc extends JpaRepository<Student, Long>{

}
