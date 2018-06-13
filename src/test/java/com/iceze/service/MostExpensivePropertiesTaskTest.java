package com.iceze.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.assertj.core.util.Arrays;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;

import com.iceze.model.Property;

public class MostExpensivePropertiesTaskTest {
	private MostExpensivePropertiesTask task;
	
	@Before
	public void setup() {
		this.task = new MostExpensivePropertiesTask();
	}

	@Test
	public void validateReturns() {
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), null))
	    	.withMessage("Invalid Percentage!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), ""))
	    	.withMessage("Invalid Percentage!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array()))
	    	.withMessage("Invalid Percentage!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array("")))
	    	.withMessage("Invalid Percentage!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array("TT")))
	    	.withMessage("Invalid Percentage!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array("-1")))
	    	.withMessage("Invalid Percentage!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
	    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(new Property()), Arrays.array("101")))
	    	.withMessage("Invalid Percentage!")
	    	.withStackTraceContaining("TaskException")
	    	.withNoCause();
	
		assertThatExceptionOfType(TaskException.class)
		    	.isThrownBy(() -> this.task.validate(null, "10"))
		    	.withMessage("Invalid properties!")
		    	.withStackTraceContaining("TaskException")
		    	.withNoCause();
		
		assertThatExceptionOfType(TaskException.class)
		    	.isThrownBy(() -> this.task.validate(Lists.newArrayList(), "10"))
		    	.withMessage("Invalid properties!")
		    	.withStackTraceContaining("TaskException")
		    	.withNoCause();
		
		assertThatCode(() -> this.task.validate(Lists.newArrayList(Property.builder().withPostcode("E6 6GG").build()), "10"))
				.doesNotThrowAnyException();
	}
	
	@Test
	public void executeReturns() {
		Object result = this.task.execute(Lists.newArrayList(
												 Property.builder().withReference("1").withPrice("1000000").build(),
												 Property.builder().withReference("2").withPrice("100000").build(),
												 Property.builder().withReference("3").withPrice("225000").build(),
												 Property.builder().withReference("4").withPrice("150000").build(),
												 Property.builder().withReference("5").withPrice("222250").build(),
												 Property.builder().withReference("6").withPrice("750000").build(),
												 Property.builder().withReference("7").withPrice("125000").build(),
												 Property.builder().withReference("8").withPrice("545444").build(),
												 Property.builder().withReference("9").withPrice("574833").build(),
												 Property.builder().withReference("10").withPrice("999999").build(),
												 Property.builder().withReference("11").withPrice("550000").build(),
												 Property.builder().withReference("12").withPrice("7500000").build(),
												 Property.builder().withReference("13").withPrice("2500000").build(),
												 Property.builder().withReference("14").withPrice("123000").build(),
												 Property.builder().withReference("15").withPrice("275000").build(),
												 Property.builder().withReference("16").withPrice("150000").build(),
												 Property.builder().withReference("17").withPrice("250000").build(),
												 Property.builder().withReference("18").withPrice("755000").build(),
												 Property.builder().withReference("19").withPrice("1010000").build(),
												 Property.builder().withReference("20").withPrice("155000").build(),
												 Property.builder().withReference("21").withPrice("245000").build(),
												 Property.builder().withReference("22").withPrice("156000").build(),
												 Property.builder().withReference("23").withPrice("222550").build(),
												 Property.builder().withReference("24").withPrice("755000").build()), 
											  "10");

		assertThat(result).isNotNull()
						  .isInstanceOf(String.class)
						  .isEqualTo("12,13");
	}
}
