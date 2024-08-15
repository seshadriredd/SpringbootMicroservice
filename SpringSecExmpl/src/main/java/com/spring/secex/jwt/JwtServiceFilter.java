package com.spring.secex.jwt;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.secex.service.UserDetailServiceimpl;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
public class JwtServiceFilter extends OncePerRequestFilter{
     
	@Autowired
	JwtService jwtService;
	@Autowired
	UserDetailServiceimpl serviceImpl;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = request.getHeader("Authorization");
		if(token == null || !token.startsWith("Bearer "))
			filterChain.doFilter(request, response);
		else {
			String jwt = token.substring(7);
			System.out.println("JWT after removign Bearer : "+jwt);
			String user = jwtService.extractUser(jwt);
			if(user != null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails userObj = serviceImpl.loadUserByUsername(user);
				if(userObj != null && jwtService.isTokenValid(jwt)) {
					UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
							user,
							userObj.getPassword(),
							userObj.getAuthorities()
							);
					authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authentication);
				}
			}
			filterChain.doFilter(request, response);
		}
		
	}
	
}
