package com.spring.learn.service;

import com.spring.learn.dao.ApiClientDto;
import com.spring.learn.dao.EmployeeDto;

public interface EmployeeDetailsInter {
	public EmployeeDto saveEmployee(EmployeeDto employeedto);
	public ApiClientDto getempDtl(Long id);
}
