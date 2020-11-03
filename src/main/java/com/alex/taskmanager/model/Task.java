package com.alex.taskmanager.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "task")
public class Task {

	@Id
	private String id;

	@NotNull(message = "Task title cannot be null")
	private String title;

	@NotNull(message = "Task status cannot be null")
	private String status;
	
	@NotNull(message = "Task category cannot be null")
	private String category;

//	TODO: Add date
//	private Date dueDate; 
}
