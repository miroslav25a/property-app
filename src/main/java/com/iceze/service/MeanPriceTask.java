package com.iceze.service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.iceze.model.Property;

/**
 * This class contains common functionality for 
 * finding the mean price in the postcode outward task.
 * 
 * @author Miroslav
 */
public class MeanPriceTask implements Task {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(final List<Property> properties, final String... arguments) throws TaskException {
		if(Objects.isNull(arguments) || arguments.length != 1 || StringUtils.isBlank(arguments[0])) {
			throw new TaskException("Invalid postcode outward!");
		}
		
		if(properties == null || properties.isEmpty()) {
			throw new TaskException("Invalid properties!");
		}
		
		if(properties.stream().filter(p -> {return p.getPostcode().startsWith(arguments[0]);})
							  .collect(Collectors.toList()).size() < 1) {
			throw new TaskException("Postcode outward not found!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String execute(final List<Property> properties, final String... arguments) {
		double average =  properties.stream().filter(p -> {return p.getPostcode().startsWith(arguments[0]);})
								  			 .collect(Collectors.toList())
								  			 .stream().mapToDouble(p -> Double.parseDouble(p.getPrice()))
								  			 .average().getAsDouble();
		
		return String.valueOf(average);
	}
}
