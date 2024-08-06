package com.task.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.task.management.entity.TaskDetails;

public interface Repository extends JpaRepository<TaskDetails, Integer> {

}
