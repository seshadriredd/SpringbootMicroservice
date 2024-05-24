package com.spring.learn.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.learn.dao.ApiClientDto;
import com.spring.learn.dao.EmployeeDto;
import com.spring.learn.service.EmployeeDetailsImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
	EmployeeDetailsImpl empdtl;
	@PostMapping("/save")
	public ResponseEntity<EmployeeDto> saveEmply(@RequestBody EmployeeDto empdto){
		return new ResponseEntity<>(empdtl.saveEmployee(empdto),HttpStatus.CREATED);
	}
	@GetMapping("{id}")
	public ResponseEntity<ApiClientDto> getEmpdetail(@PathVariable Long id){
		return new ResponseEntity<ApiClientDto>(empdtl.getempDtl(id),HttpStatus.OK);
	}
	@GetMapping("/delete")
	public ResponseEntity<String> deleteAll(){
		String message = empdtl.deleteAllByName();
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	@GetMapping("/fetchAll")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		return new ResponseEntity<List<EmployeeDto>>(empdtl.getAllEmployee(),HttpStatus.OK);
	}
}
