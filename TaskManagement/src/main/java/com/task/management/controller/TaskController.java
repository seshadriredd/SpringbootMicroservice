package com.task.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.management.dto.TaskDetailsDto;
import com.task.management.service.TaskServiceDetails;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TaskController {
	@Autowired
	TaskServiceDetails details;
	@PostMapping("/saveTask")
	public ResponseEntity<TaskDetailsDto> saveTask(@RequestBody TaskDetailsDto dto){
		return new ResponseEntity<TaskDetailsDto>(details.saveTask(dto),HttpStatus.OK);
	}
	@GetMapping("/getAllTasks")
	public ResponseEntity<List<TaskDetailsDto>> findAll(){
		return new ResponseEntity<List<TaskDetailsDto>>(details.findAll(),HttpStatus.OK);
	}
	@GetMapping("/id/{id}") //using the path param(@PathVariable
	public ResponseEntity<TaskDetailsDto> getById(@PathVariable Integer id){
		return new ResponseEntity<TaskDetailsDto>(details.getById(id),HttpStatus.OK);
		
	}
}
