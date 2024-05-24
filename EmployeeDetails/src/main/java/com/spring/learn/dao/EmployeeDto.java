package com.spring.learn.dao;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDto {
	Long id;
	String name;
	String emailId;
	String empId;
	Integer salary;
	String domain;
	
}
