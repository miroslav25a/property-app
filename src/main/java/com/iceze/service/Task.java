package com.iceze.service;

import java.util.List;

import com.iceze.model.Property;

/**
 * This interface contains common functionality for task.
 * 
 * @author Miroslav
 */
public interface Task {
	
	/**
	 * This method validates the arguments for the task.
	 * 
	 * @param properties, List<Property> representation of properties
	 * @param arguments, String[] containing arguments.
	 * 
	 * @throws TaskException, if the arguments are invalid.
	 * 
	 */
	void validate(final List<Property> properties, final String... arguments) throws TaskException;
	
	/**
	 * This method executes a task against the given list and arguments.
	 * 
	 * @param properties, List<Property> representation of properties
	 * @param arguments, String[] containing arguments.
	 * 
	 * @return String, result
	 */
	String execute(final List<Property> properties, final String... arguments);
}
