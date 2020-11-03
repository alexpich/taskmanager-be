package com.alex.taskmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.alex.taskmanager.model.Task;

public interface TaskRepository extends MongoRepository<Task, String> {

}
