package com.spring.learn.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.learn.Dto.EmpDomaindtlsDto;
import com.spring.learn.entity.EmpDomaindtls;
import com.spring.learn.repository.EmpDomaindinter;
import com.spring.learn.utility.DomainToDto;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmpDomaindtlsImpl implements EmpDomainInter {
	
	EmpDomaindinter repo;
	DomainToDto trans;
	private  DomainToDto dtovsdo;
	public EmpDomaindtlsDto saveDomainDetails(EmpDomaindtlsDto empdto) {
		EmpDomaindtls domainObj = dtovsdo.DtoToEmpDomaindtls(empdto);
		EmpDomaindtls empobj = repo.save(domainObj);
		return dtovsdo.EmpDomainToDto(empobj);
	}
	@Override
	public EmpDomaindtlsDto getDomainDetails(Long id) {
		EmpDomaindtls obj = repo.findById(id).get();
		return dtovsdo.EmpDomainToDto(obj);
	}
	@Override
	public List<EmpDomaindtlsDto> getAllDomain() {
		return repo.findAll()
				.stream().
				map(obj-> trans.EmpDomainToDto(obj))
						.collect(Collectors.toList());
	}
	public EmpDomaindtlsDto getbyId(Long id) {
		EmpDomaindtls val = repo.findById(id).get();
		return trans.EmpDomainToDto(val);
	}
	public EmpDomaindtlsDto getByDomain(String name) {
		EmpDomaindtls val = repo.findByDomain(name);
		return trans.EmpDomainToDto(val);
	}

}
