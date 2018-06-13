package com.iceze.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.iceze.model.Property;

/**
 * This class contains the implementation to list the most expensive properties.
 * 
 * @author miroslav
 */
public class MostExpensivePropertiesTask implements Task {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void validate(final List<Property> properties, final String... arguments) throws TaskException {
		if(Objects.isNull(arguments) || arguments.length != 1 || StringUtils.isBlank(arguments[0])) {
			throw new TaskException("Invalid Percentage!");
		}
		
		try {
			int percentage = Integer.parseInt(arguments[0]);
			if(percentage < 0 || percentage > 100) {
				throw new TaskException("Invalid Percentage!");
			}
		} catch(NumberFormatException e) {
			throw new TaskException("Invalid Percentage!");
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
		BigDecimal topSize = (new BigDecimal(properties.size()).multiply(new BigDecimal(arguments[0])))
																 .divide(new BigDecimal(100), RoundingMode.HALF_UP);
		
		Comparator<Property> priceComparator = (o1, o2) -> new BigDecimal(o1.getPrice()).compareTo(new BigDecimal(o2.getPrice()));
		properties.sort(priceComparator.reversed());
		
		String references = properties.subList(0, topSize.intValue()).stream().map(p -> p.getReference()).collect(Collectors.joining(","));
		
		return references;
	}
}
