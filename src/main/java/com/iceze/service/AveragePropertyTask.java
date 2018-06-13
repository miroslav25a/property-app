package com.iceze.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.iceze.model.Property;
import com.iceze.model.PropertyType;

/**
 * This class contains the common task functionality to find 
 * the difference in average property prices between two different property types.
 * 
 * @author Miroslav
 */
public class AveragePropertyTask implements Task {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(final List<Property> properties, final String... arguments) throws TaskException {
		if(Objects.isNull(arguments) || arguments.length != 2 || 
				StringUtils.isBlank(arguments[0]) || StringUtils.isBlank(arguments[1]) ||
					PropertyType.findByDisplayName(arguments[0]) == null || 
						PropertyType.findByDisplayName(arguments[1]) == null) {
			throw new TaskException("Invalid Property Types!");
		}
		
		if(properties == null || properties.isEmpty()) {
			throw new TaskException("Invalid properties!");
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String execute(final List<Property> properties, final String... arguments) {
		double detachedAverage =  properties.stream().filter(p -> {return p.getType().equals(PropertyType.findByDisplayName(arguments[0]));})
										  			 .collect(Collectors.toList())
										  			 .stream().mapToDouble(p -> Double.parseDouble(p.getPrice()))
										  			 .average().getAsDouble();
		
		double flatAverage =  properties.stream().filter(p -> {return p.getType().equals(PropertyType.findByDisplayName(arguments[1]));})
										  		 .collect(Collectors.toList())
										  		 .stream().mapToDouble(p -> Double.parseDouble(p.getPrice()))
										  		 .average().getAsDouble();
		
		return (new BigDecimal(detachedAverage).subtract(new BigDecimal(flatAverage))).toString();
	}
}
