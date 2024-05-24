package com.spring.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.learn.entity.EmpDomaindtls;

public interface EmpDomaindinter extends JpaRepository<EmpDomaindtls, Long> {
	public EmpDomaindtls findByDomain(String name);
}
