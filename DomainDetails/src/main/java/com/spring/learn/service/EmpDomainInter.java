package com.spring.learn.service;

import java.util.List;

import com.spring.learn.Dto.EmpDomaindtlsDto;

public interface EmpDomainInter {
	public EmpDomaindtlsDto saveDomainDetails(EmpDomaindtlsDto empdto);
	public EmpDomaindtlsDto getDomainDetails(Long id);
	public List<EmpDomaindtlsDto> getAllDomain();
	public EmpDomaindtlsDto getbyId(Long id);
	public EmpDomaindtlsDto getByDomain(String name);
}
