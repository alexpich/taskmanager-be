package com.alex.taskmanager.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alex.taskmanager.exception.TaskCollectionException;
import com.alex.taskmanager.model.Task;
import com.alex.taskmanager.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepo;
	
	public void createTask(Task task) {
		taskRepo.save(task);
	}
	
	public List<Task> getAllTasks() {
		List<Task> tasks = taskRepo.findAll();
		
		if(tasks.size() > 0 ) {
			return tasks;
		} else {
			return new ArrayList<Task>();
		}
	}
	
	public void deleteTaskById(String id) throws TaskCollectionException {
		Optional<Task> taskOptional = taskRepo.findById(id);
		
		if(!taskOptional.isPresent()) {
			throw new TaskCollectionException(TaskCollectionException.NotFoundException(id));
		} else {
			taskRepo.deleteById(id);
		}
	}
	
	public void updateTask(String id, Task newTask) throws TaskCollectionException {
		Optional<Task> taskWithId = taskRepo.findById(id);
		
		if(taskWithId.isPresent()) {
			Task taskToUpdate = taskWithId.get();
			BeanUtils.copyProperties(newTask, taskToUpdate);
			
			// Ensure that newTask doesn't get added as a new document
			taskToUpdate.setId(id);
			taskRepo.save(taskToUpdate);
		} else {
			throw new TaskCollectionException(TaskCollectionException.NotFoundException(id));
		}
	}
}
