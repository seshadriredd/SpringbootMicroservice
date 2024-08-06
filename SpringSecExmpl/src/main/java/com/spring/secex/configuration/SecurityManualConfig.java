package com.spring.secex.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityManualConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    	http
    		.csrf(customizer->customizer.disable())
    		.authorizeHttpRequests(request->request.anyRequest().authenticated())
				/*
				 * .authorizeHttpRequests((authorizeHttpRequests) -> authorizeHttpRequests
				 * .requestMatchers("/admin/**").hasRole("ADMIN")
				 * .requestMatchers("/**").hasRole("USER") )
				 */
			//.formLogin(withDefaults()) -- we commented because at browser will ask again and again username and passoword so using basicHttp we can go
    		.httpBasic(withDefaults())
    		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}
}
