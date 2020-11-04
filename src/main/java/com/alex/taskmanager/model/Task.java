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

	public Task() {

	}

	public Task(String id, @NotNull(message = "Task title cannot be null") String title,
			@NotNull(message = "Task status cannot be null") String status,
			@NotNull(message = "Task category cannot be null") String category) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", status=" + status + ", category=" + category + "]";
	}

//	TODO: Add date
//	private Date dueDate; 
}
