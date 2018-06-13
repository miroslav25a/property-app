package com.iceze.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import com.iceze.model.Property;

public class BasicTaskManagerTest {
	private BasicTaskManager manager;
	
	@Before
	public void setup() {
		this.manager = new BasicTaskManager();
	}

	@Test
	public void executeTaskReturns() {
		Object result = this.manager.executeTask(
										Lists.newArrayList(
											 Property.builder().withPostcode("E6 6GG").withPrice("10").build(),
											 Property.builder().withPostcode("E6 6GG").withPrice("100").build(),
											 Property.builder().withPostcode("E6 6GG").withPrice("40").build(),
											 Property.builder().withPostcode("E5 6GG").withPrice("50").build()), 
										"1", "E6");
		
		assertThat(result).isNotNull()
		  				  .isInstanceOf(String.class)
		  				  .isEqualTo("50.0");
	}
	
	@Test
	public void executeTaskReturnsNull() {
		Object result = this.manager.executeTask(
										Lists.newArrayList(
											 Property.builder().withPostcode("E6 6GG").withPrice("10").build(),
											 Property.builder().withPostcode("E6 6GG").withPrice("100").build(),
											 Property.builder().withPostcode("E6 6GG").withPrice("40").build(),
											 Property.builder().withPostcode("E5 6GG").withPrice("50").build()), 
										"4", "E6");
		
		assertThat(result).isNotNull()
						  .isEqualTo("Command Not Found!");
	}
}
