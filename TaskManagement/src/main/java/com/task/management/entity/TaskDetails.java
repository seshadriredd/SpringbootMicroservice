package com.task.management.entity;

import java.time.LocalDateTime;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class TaskDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	@Nonnull
	String taskTitle;
	@Nonnull
	String taskDescription;
	LocalDateTime taskDueDate;
	LocalDateTime lastUpdated;
	LocalDateTime ts = LocalDateTime.now();

	public TaskDetails() {
		super();
	}

	public TaskDetails(String taskTitle, String taskDescription, LocalDateTime taskDueDate, LocalDateTime lastUpdated) {
		super();
		this.taskTitle = taskTitle;
		this.taskDescription = taskDescription;
		this.taskDueDate = taskDueDate;
		this.lastUpdated = lastUpdated;
	}

}
