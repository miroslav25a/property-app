package com.iceze.service;

import static com.iceze.util.Constants.DEFAULT_OUTCOME;

import java.util.Arrays;
import java.util.List;

import com.iceze.model.Property;

/**
 * Basic implementation of the task manager.
 * 
 * @author Miroslav
 */
public class BasicTaskManager implements TaskManager {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String executeTask(final List<Property> properties, final String... arguments) throws TaskException {
		String[] args = Arrays.stream(arguments).skip(1).toArray(String[]::new);
		String outcome = null;
		
		// For Rightmove it's important to use a switch here and avoid a Map<String, Task>.
		switch (arguments[0]) {
			case "1": 	Task meanPriceTask = new MeanPriceTask();
						meanPriceTask.validate(properties, args);
						outcome = meanPriceTask.execute(properties, args);
						break;
			case "2": 	Task averagePropertyTask = new AveragePropertyTask();
						averagePropertyTask.validate(properties, args);
						outcome = averagePropertyTask.execute(properties, args);
						break;
			case "3":	Task mostExpensivePropertiesTask = new MostExpensivePropertiesTask();
						mostExpensivePropertiesTask.validate(properties, args);
						outcome = mostExpensivePropertiesTask.execute(properties, args);
						break;
			default: 	outcome = DEFAULT_OUTCOME;
		}
		
		return outcome;
	}
}
