package com.spring.secex.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spring.secex.jwt.JwtServiceFilter;
import com.spring.secex.service.UserDetailServiceimpl;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;

@Configuration
@EnableWebSecurity
public class SecurityManualConfig {
	
	@Autowired
	JwtServiceFilter jwtServiceFilter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	System.out.println("Inside the securityFilterchain");
    	http
    		.csrf(customizer->customizer.disable())
    		//.authorizeHttpRequests(request->request.anyRequest().authenticated())
			.authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
					.requestMatchers("/api/admin/**").hasRole("ADMIN")
					.requestMatchers("/api/user/**").hasRole("USER")
					.requestMatchers("/api/gm/**").hasRole("GM")
					.requestMatchers("/login","/register").permitAll()
					.requestMatchers("/**").permitAll())
			//.formLogin(withDefaults()) -- we commented because at browser will ask again and again username and passoword so using basicHttp we can go
    		.httpBasic(withDefaults())
    		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
    		.addFilterBefore(jwtServiceFilter,UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
    //Note: while setting authorization SecurityFiletrChain class we have use .hasRole("AMIN") or .hasRole("USER") or .hasROle("GM") etc...
    //BUT when it comes to the DB we need to save as like ROLE_ADMIN,ROLE_USER,ROLE_GM etc.. ROLE_ROLENAME IS mandatory 
	
	/*
	 * @Bean public UserDetailsService userDetailService() { UserDetails user1 =
	 * User.withDefaultPasswordEncoder().username("seshadri").password("s@123").
	 * roles("USER") .build(); UserDetails user2 =
	 * User.withDefaultPasswordEncoder().username("Ram").password("r@123").roles(
	 * "ADMIN").build(); UserDetails user3 =
	 * User.withDefaultPasswordEncoder().username("Sam").password("s@123").roles(
	 * "GM").build(); return new InMemoryUserDetailsManager(user1, user2, user3);
	 * 
	 * }
	 */
	 
	
	@Bean
	public UserDetailsService userDetailService() {
		System.out.println("Inside the UserDetailService Method");
		return new UserDetailServiceimpl();
	}
	 
    @Bean
    public AuthenticationProvider provider() {
    	System.out.println("Inside the Dao authentication provider");
    	DaoAuthenticationProvider dao = new DaoAuthenticationProvider();
    	dao.setPasswordEncoder(new BCryptPasswordEncoder());
    	dao.setUserDetailsService(userDetailService());
		return dao;
    	
    }
    @Bean
    public AuthenticationManager authenticationManager() {
		return new ProviderManager(provider());
    	
    }
}
