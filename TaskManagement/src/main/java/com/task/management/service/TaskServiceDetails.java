package com.task.management.service;

import java.time.LocalDateTime;
import java.util.List;

import com.task.management.dto.TaskDetailsDto;

public interface TaskServiceDetails {
	public TaskDetailsDto saveTask(TaskDetailsDto dtObj); // using post

	public TaskDetailsDto getById(Integer id); // using get

	public TaskDetailsDto getByIdDescription(String description); // using get

	public TaskDetailsDto getFutureDate(LocalDateTime date); // using get

	public List<TaskDetailsDto> findAll(); // using get

	public TaskDetailsDto updateTitle(String newTitle); // using put

	public TaskDetailsDto updateByPatch(String newTitle); // using patch

	public String deleteTaskByTitle(String title); // using delete
}
