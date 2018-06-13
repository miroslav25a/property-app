package com.iceze.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.common.collect.Lists;

import com.iceze.model.Property;
import com.iceze.model.PropertyType;


/**
 * Utility class for loading file data
 * 
 * @author Miroslav
 */
public final class LoadFromFileUtil {
	
	/**
	 * Default Constructor.
	 * Prevent the class from being constructed.
	 */
    private LoadFromFileUtil() {
    }
	
	/**
	 * Load a list of properties from a file
	 * 
	 * @param filePath
	 * 			String, a path to properties file
	 * 
	 * @return List<Property>
	 * @throws IOException
	 */
	public static List<Property> loadProperties(final String filePath) throws IOException {
		String source = new String(Files.readAllBytes(Paths.get(filePath)));
		List<Property> contracts = convertProperties(source);
		
		return contracts;
	}
	
	/**
	 * Convert the given source to properties
	 * @param source
	 * 			String, represents properties
	 * 
	 * @return List<Property>
	 */
	public static List<Property> convertProperties(final String source) {
		List<Property> properties = Lists.newArrayList();
		
		String[] split = source.split(Constants.LINE_END, -1);
		
		Arrays.stream(split).skip(1).forEach(s -> {
			String[] lineSplit = s.split(Constants.COLUMN_SEPARATOR);

			Property p = Property.builder().withReference(lineSplit[0])
										   .withPrice(lineSplit[1])
										   .withBedrooms(lineSplit[2])
										   .withBathrooms(lineSplit[3])
										   .withHouseNumber(lineSplit[4])
										   .withAddress(lineSplit[5])
										   .withRegion(lineSplit[6])
										   .withPostcode(lineSplit[7])
										   .withType(PropertyType.findByDisplayName(lineSplit[8]))
										   .build();

			properties.add(p);
		});
		
		return properties;
	}
}
