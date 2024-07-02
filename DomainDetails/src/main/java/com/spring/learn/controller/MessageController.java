package com.spring.learn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class MessageController {
	
	@Value("${spring.boot.message}")
	private String vaalue;
	
	@RequestMapping("/hi")
	public ResponseEntity<String> hiMessage(){
		return new ResponseEntity<String>(vaalue,HttpStatus.OK);
	}
}
