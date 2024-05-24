package com.spring.learn.utility;

import org.springframework.stereotype.Component;

import com.spring.learn.Dto.EmpDomaindtlsDto;
import com.spring.learn.entity.EmpDomaindtls;

@Component
public class DomainToDto {
	
	public EmpDomaindtlsDto EmpDomainToDto(EmpDomaindtls empobj) {
		EmpDomaindtlsDto dto = new EmpDomaindtlsDto(
				empobj.getId(),
				empobj.getDomain(),
				empobj.getInfo(),
				empobj.getExp(),
				empobj.getKnwldgndex(),
				empobj.getPrjctnm());
		return dto;
	}
	public EmpDomaindtls DtoToEmpDomaindtls(EmpDomaindtlsDto empdto) {
		EmpDomaindtls domainObj = new EmpDomaindtls(
				empdto.getId(),
				empdto.getDomain(),
				empdto.getInfo(),
				empdto.getExp(),
				empdto.getKnwldgndex(),
				empdto.getPrjctnm()
				);
		return domainObj;
	}
	
}
