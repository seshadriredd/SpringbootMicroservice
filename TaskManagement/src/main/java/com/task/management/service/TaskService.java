package com.task.management.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.task.management.dao.Repository;
import com.task.management.dto.MappingClass;
import com.task.management.dto.TaskDetailsDto;
import com.task.management.entity.TaskDetails;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskService implements TaskServiceDetails {
	
	Repository repo;
	@Override
	public TaskDetailsDto saveTask(TaskDetailsDto dtObj) {
		TaskDetails taskobj= new MappingClass().actObj(dtObj);
		TaskDetails obj1= repo.save(taskobj);
		return new MappingClass().dtoObj(obj1);
	}

	@Override
	public TaskDetailsDto getById(Integer id) {
		return new MappingClass().dtoObj(repo.findById(id).get());
	}

	@Override
	public TaskDetailsDto getByIdDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDetailsDto getFutureDate(LocalDateTime date) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<TaskDetailsDto> findAll() {
		return repo.findAll().stream().map(a -> new MappingClass().dtoObj(a)).collect(Collectors.toList());
	}

	@Override
	public TaskDetailsDto updateTitle(String newTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TaskDetailsDto updateByPatch(String newTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteTaskByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
