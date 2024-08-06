package com.task.management.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data 
public class TaskDetailsDto {

	Integer id;
	String taskTitle;
	String taskDescription;
	LocalDateTime taskDueDate;
	LocalDateTime lastUpdated;
}
