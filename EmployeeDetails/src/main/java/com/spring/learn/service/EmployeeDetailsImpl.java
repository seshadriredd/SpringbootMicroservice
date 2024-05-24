package com.spring.learn.service;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.learn.dao.ApiClientDto;
import com.spring.learn.dao.EmpDomaindtlsDto;
import com.spring.learn.dao.EmployeeDto;
import com.spring.learn.entity.Employee;
import com.spring.learn.repository.Repositoryint;
import com.spring.learn.servicecomm.ApiClient;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeDetailsImpl implements EmployeeDetailsInter{
	
	private Repositoryint repo;
	private ApiClient api;
	@Override
	public EmployeeDto saveEmployee(EmployeeDto empdto) {
		Employee emp = new Employee(
				empdto.getId(),
				empdto.getName(),
				empdto.getEmailId(),
				empdto.getEmpId(),
				empdto.getSalary(),
				empdto.getDomain()
				);
		System.out.println("get saL"+empdto.getSalary());
		Employee empdtl = repo.save(emp);
		EmployeeDto empdtil = new EmployeeDto(
				empdtl.getId(),
				empdtl.getName(),
				empdtl.getEmailId(),
				empdtl.getEmpId(),
				empdtl.getSalary(),
				empdtl.getDomain()
				);
		System.out.println("get saL"+empdtl.getSalary());
		return empdtil;
	}
	public ApiClientDto getempDtl(Long id) {
		Employee emp= repo.findById(id).get();
		EmployeeDto obj = new EmployeeDto(emp.getId(),emp.getName(),emp.getEmailId(),emp.getEmpId(),emp.getSalary(),emp.getDomain());
		EmpDomaindtlsDto domainobj = api.getByDomain(emp.getDomain());
		ApiClientDto apidto = new ApiClientDto();
		apidto.setEmpdodto(domainobj);
		apidto.setEmpdto(obj);
		return apidto;
	}
	public String deleteAllByName() {
			repo.deleteAll();
			return "Records deletion successful";
		
	}
	public List<EmployeeDto> getAllEmployee() {
		return repo.findAll().stream()
				.map(emp-> new EmployeeDto(emp.getId(),emp.getName(),emp.getEmailId(),emp.getEmpId(),emp.getSalary(),emp.getDomain()))
						.collect(Collectors.toList());
	}
}
