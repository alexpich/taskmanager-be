package com.alex.taskmanager.exception;

public class TaskCollectionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TaskCollectionException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Task with " + id + " not found";
	}
	
}
