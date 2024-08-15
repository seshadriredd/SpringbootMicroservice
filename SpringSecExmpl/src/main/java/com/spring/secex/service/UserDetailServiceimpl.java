package com.spring.secex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.secex.dao.UserRepository;
import com.spring.secex.model.Users;

@Service
public class UserDetailServiceimpl implements UserDetailsService {
	
	@Autowired
	UserRepository repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Inside loaduserby username method : "+username);
		Users user = repo.findByUsername(username);
		if (user==null) {
			System.out.println("Hey seshadri user not found");
			throw new UsernameNotFoundException("User not found"+user);
		}
		return new UserInfo(user);
	}

}
