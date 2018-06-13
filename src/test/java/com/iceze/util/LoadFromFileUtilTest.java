package com.iceze.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.iceze.model.Property;
import com.iceze.model.PropertyType;

public class LoadFromFileUtilTest {

	@SuppressWarnings("unchecked")
	@Test
	public void convertPropertiesReturns() {
		String source = this.createPropertyDataSource();
		
		Object result = LoadFromFileUtil.convertProperties(source);
		
		assertThat(result).isNotNull().isInstanceOf(ArrayList.class);
		
		
		List<Property> properties = (ArrayList<Property>) result;
		assertThat(properties).isNotEmpty();
		assertThat(properties.size()).isEqualTo(1);
		assertThat(properties.get(0).getReference()).isNotNull().isEqualTo("1");
		assertThat(properties.get(0).getPrice()).isNotNull().isEqualTo("1000000");
		assertThat(properties.get(0).getBedrooms()).isNotNull().isEqualTo("7");
		assertThat(properties.get(0).getBathrooms()).isNotNull().isEqualTo("2");
		assertThat(properties.get(0).getHouseNumber()).isNotNull().isEqualTo("12");
		assertThat(properties.get(0).getAddress()).isNotNull().isEqualTo("Richard Lane");
		assertThat(properties.get(0).getRegion()).isNotNull().isEqualTo("London");
		assertThat(properties.get(0).getPostcode()).isNotNull().isEqualTo("W1F 3FT");
		assertThat(properties.get(0).getType()).isNotNull().isEqualTo(PropertyType.MANSION);
	}
	
	private String createPropertyDataSource() {
		String source = "PROPERTY_REFERENCE,PRICE,BEDROOMS,BATHROOMS,HOUSE_NUMBER,ADDRESS,REGION,POSTCODE,PROPERTY_TYPE\r\n" + 
						"1,1000000,7,2,12,Richard Lane,London,W1F 3FT,Mansion";
		
		return source;
	}
}
