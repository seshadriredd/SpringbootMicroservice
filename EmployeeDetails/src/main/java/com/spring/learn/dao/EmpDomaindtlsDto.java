package com.spring.learn.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpDomaindtlsDto {
	
		Long id;
		String domain;
		String info;
		float exp;
		Integer knwldgndex;
		String prjctnm; 
}
