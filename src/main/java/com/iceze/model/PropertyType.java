package com.iceze.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * This enum contains common property types.
 * 
 * @author Miroslav
 */
public enum PropertyType {
	MANSION("Mansion"),
    TERRACED("Terraced"),
    DETACHED("Detached"),
    FLAT("Flat");

    private String displayName;

    PropertyType(final String displayName) {
        this.displayName = displayName;
    }

    public String displayName() {
        return this.displayName;
    }
    
    /**
     * Find Property Type by the given display name.
     * @param displayName, String representing display name.
     * 
     * @return PropertyType
     */
    public static PropertyType findByDisplayName(final String displayName) {
    	List<PropertyType> list = Arrays.asList(PropertyType.values()).stream().filter(t -> t.displayName.equals(displayName))
    																		   .collect(Collectors.toList());
    	return (list.isEmpty()) ? null : list.get(0);
    }
}
