package com.spring.learn.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="DomainDtls")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmpDomaindtls {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String domain;
	String info;
	float exp;
	Integer knwldgndex;
	String prjctnm; 
}
