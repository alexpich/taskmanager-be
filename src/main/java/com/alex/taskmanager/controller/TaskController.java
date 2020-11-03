package com.alex.taskmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.alex.taskmanager.service.TaskService;

@RestController
public class TaskController {
	
	@Autowired
	private TaskService taskService;
}
