package com.task.management.dto;

import com.task.management.entity.TaskDetails;

public class MappingClass {
	TaskDetails entity;
	TaskDetailsDto dto;

	public TaskDetails actObj(TaskDetailsDto dtoObj) {
		return new TaskDetails(dtoObj.getTaskTitle(), dtoObj.getTaskDescription(), dtoObj.getTaskDueDate(),
				dtoObj.getTaskDueDate());
	}

	public TaskDetailsDto dtoObj(TaskDetails taskObj) {
		return new TaskDetailsDto(taskObj.getId(), taskObj.getTaskTitle(), taskObj.getTaskDescription(),
				taskObj.getTaskDueDate(), taskObj.getLastUpdated());
	}
}
