package com.iceze.service;

import java.util.List;

import com.iceze.model.Property;

/**
 * This interface contains common functionality for the task manager.
 * 
 * @author Miroslav
 */
public interface TaskManager {
	/**
	 * This method executes a task against the given list and arguments.
	 * 
	 * @param properties, List<Property> representation of properties
	 * @param arguments, String[] containing arguments.
	 * 
	 * @return String, result
	 * @throws TaskException, if the arguments are invalid.
	 */
	String executeTask(final List<Property> properties, final String... arguments) throws TaskException;
}
