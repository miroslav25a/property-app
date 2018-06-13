package com.iceze.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import com.iceze.model.Property;

public class MeanPriceTaskTest {
	private MeanPriceTask task;
	
	@Before
	public void setup() {
		this.task = new MeanPriceTask();
	}

	@Test
	public void validateReturns() {
		assertThatExceptionOfType(TaskException.class)
        	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), null))
        	.withMessage("Invalid postcode outward!")
        	.withStackTraceContaining("TaskException")
        	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), ""))
	    	.withMessage("Invalid postcode outward!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array()))
	    	.withMessage("Invalid postcode outward!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array("")))
	    	.withMessage("Invalid postcode outward!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array("", "")))
	    	.withMessage("Invalid postcode outward!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(Property.builder().withPostcode("E6 6GG").build()), Arrays.array("E5")))
	    	.withMessage("Postcode outward not found!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(null, "E6"))
	    	.withMessage("Invalid properties!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
	
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(), "E6"))
	    	.withMessage("Invalid properties!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatCode(() -> this.task.validate(Lists.newArrayList(Property.builder().withPostcode("E6 6GG").build()), Arrays.array("E6")))
			.doesNotThrowAnyException();
	}
	
	@Test
	public void executeReturns() {
		Object result = this.task.execute(Lists.newArrayList(
											 Property.builder().withPostcode("E6 6GG").withPrice("10").build(),
											 Property.builder().withPostcode("E6 6GG").withPrice("100").build(),
											 Property.builder().withPostcode("E6 6GG").withPrice("40").build(),
											 Property.builder().withPostcode("E5 6GG").withPrice("50").build()), 
										  "E6");
		
		assertThat(result).isNotNull()
						  .isInstanceOf(String.class)
						  .isEqualTo("50.0");
	}
}
