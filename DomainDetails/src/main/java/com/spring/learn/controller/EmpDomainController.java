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

import com.spring.learn.Dto.EmpDomaindtlsDto;
import com.spring.learn.service.EmpDomaindtlsImpl;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/domain")
@AllArgsConstructor
public class EmpDomainController {
	
	EmpDomaindtlsImpl domobj;
	@PostMapping("/save")
	public ResponseEntity<EmpDomaindtlsDto> saveDomain(@RequestBody EmpDomaindtlsDto empdto){
		return new ResponseEntity<EmpDomaindtlsDto>( domobj.saveDomainDetails(empdto),HttpStatus.CREATED);
	}
	@GetMapping("/getAllDomains")
	public ResponseEntity<List<EmpDomaindtlsDto>> fetchAll(){
		return new ResponseEntity<>(domobj.getAllDomain(),HttpStatus.OK);
	}
	@GetMapping("/id/{id}")
	public ResponseEntity<EmpDomaindtlsDto> getById(@PathVariable Long id){
		return new ResponseEntity<>(domobj.getbyId(id),HttpStatus.OK);
	}
	@GetMapping("{name}")
	public ResponseEntity<EmpDomaindtlsDto> getByDomain(@PathVariable String name){
		return new ResponseEntity<>(domobj.getByDomain(name),HttpStatus.OK);
	}
}
