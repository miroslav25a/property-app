package com.iceze.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import com.iceze.model.Property;
import com.iceze.model.PropertyType;

public class AveragePropertyTaskTest {
	private AveragePropertyTask task;
	
	@Before
	public void setup() {
		this.task = new AveragePropertyTask();
	}
	
	@Test
	public void validateReturns() {
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), null))
	    	.withMessage("Invalid Property Types!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), ""))
	    	.withMessage("Invalid Property Types!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array()))
	    	.withMessage("Invalid Property Types!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array("")))
	    	.withMessage("Invalid Property Types!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
			.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array("", "")))
			.withMessage("Invalid Property Types!")
			.withStackTraceContaining("TaskException")
			.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
			.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array("Detached", "TT")))
			.withMessage("Invalid Property Types!")
			.withStackTraceContaining("TaskException")
			.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
			.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array("TT", "Flat")))
			.withMessage("Invalid Property Types!")
			.withStackTraceContaining("TaskException")
			.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
		    	.isThrownBy(() -> this.task.validate(null, "Detached", "Flat"))
		    	.withMessage("Invalid properties!")
		    	.withStackTraceContaining("TaskException")
		    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
		    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(), "Detached", "Flat"))
		    	.withMessage("Invalid properties!")
		    	.withStackTraceContaining("TaskException")
		    	.withNoCause();
		
		assertThatCode(() -> this.task.validate(Lists.newArrayList(Property.builder().withPostcode("E6 6GG").build()), "Detached", "Flat"))
				.doesNotThrowAnyException();
	}
	
	@Test
	public void executeReturns() {
		Object result = this.task.execute(Lists.newArrayList(
												 Property.builder().withType(PropertyType.DETACHED).withPrice("10").build(),
												 Property.builder().withType(PropertyType.DETACHED).withPrice("100").build(),
												 Property.builder().withType(PropertyType.DETACHED).withPrice("40").build(),
												 Property.builder().withType(PropertyType.FLAT).withPrice("20").build(),
												 Property.builder().withType(PropertyType.FLAT).withPrice("30").build()), 
											"Detached", "Flat");

		assertThat(result).isNotNull()
						  .isInstanceOf(String.class)
						  .isEqualTo("25");
	}
}
