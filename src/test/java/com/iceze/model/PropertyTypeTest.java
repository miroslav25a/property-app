package com.iceze.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class PropertyTypeTest {

	@Test
	public void findByDisplayNameReturns() {
		Object result = PropertyType.findByDisplayName("Flat");
		
		assertThat(result).isNotNull()
						  .isInstanceOf(PropertyType.class)
						  .isEqualTo(PropertyType.FLAT);
		
		result = PropertyType.findByDisplayName("Flatt");
		
		assertThat(result).isNull();
	}
	
	@Test
	public void displayNameReturns() {
		Object result = PropertyType.FLAT.displayName();
		
		assertThat(result).isNotNull()
						  .isInstanceOf(String.class)
						  .isEqualTo("Flat");
	}
}
