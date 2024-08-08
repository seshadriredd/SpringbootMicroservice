package com.spring.secex.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.secex.model.Users;

public class UserInfo implements UserDetails {
	
	private String username;
	private String password;
	private List<GrantedAuthority> authorities;
	
	public UserInfo() {
		super();
	}

	public UserInfo(Users user) {
		System.out.println("Inside the users class Constructor");
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.authorities = Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		authorities.stream().forEach(a->System.out.println("Inside loop of authorities : "+a));
		return authorities;
	}

	@Override
	public String getPassword() {
		System.out.println("Inside the users class password: "+password);
		return password;
	}

	@Override
	public String getUsername() {
		System.out.println("Inside the users class username: "+username);
		return username;
	}

}
