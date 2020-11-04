package com.alex.taskmanager.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.alex.taskmanager.exception.TaskCollectionException;
import com.alex.taskmanager.model.Task;
import com.alex.taskmanager.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	private TaskService taskService;

	@PostMapping("/task")
	public ResponseEntity<String> createTask(@RequestBody Task task) {
		try {
			taskService.createTask(task);
			return new ResponseEntity("Successfully added task " + task.getTitle(), HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@GetMapping("/task")
	public ResponseEntity<String> getAllTasks() {
		List<Task> tasks = taskService.getAllTasks();
		return new ResponseEntity(tasks, tasks.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/task/{id}")
	public ResponseEntity deleteTaskById(@PathVariable("id") String id) {
		try {
			taskService.deleteTaskById(id);
			return new ResponseEntity("Sucessfully deleted task with id " + id, HttpStatus.OK);
		} catch (TaskCollectionException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	@PutMapping("/task/{id}")
	public ResponseEntity updateById(@PathVariable("id") String id, @RequestBody Task newTask) {
		try {
			taskService.updateTask(id, newTask);
			return new ResponseEntity("Successfully updated task with id " + id, HttpStatus.OK);
		} catch (ConstraintViolationException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		} catch (TaskCollectionException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
