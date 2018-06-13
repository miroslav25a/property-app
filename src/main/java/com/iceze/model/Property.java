package com.iceze.model;

/**
 * Class representation of the property.
 * 
 * @author Miroslav
 */
public class Property {
	private String reference;
	private String price;
	private String bedrooms;
	private String bathrooms;
	private String houseNumber;
	private String address;
	private String region;
	private String postcode;
	private PropertyType type;
	
	/**
	 * Default Constructor
	 */
	public Property() {
		this.reference = null;
		this.price = null;
		this.bedrooms = null;
		this.bathrooms = null;
		this.houseNumber = null;
		this.address = null;
		this.region = null;
		this.postcode = null;
		this.type = null;
	}
	
	/**
     * Parameterized Constructor
     * 
     * @param builder, Builder for the Property
     */
    private Property(final Builder builder)
    {
        this.reference = builder.reference;
        this.price = builder.price;
        this.bedrooms = builder.bedrooms;
        this.bathrooms = builder.bathrooms;
        this.houseNumber = builder.houseNumber;
        this.address = builder.address;
        this.region = builder.region;
        this.postcode = builder.postcode;
        this.type = builder.type;
    }
	
	public String getReference() {
		return reference;
	}

	public String getPrice() {
		return price;
	}

	public String getBedrooms() {
		return bedrooms;
	}

	public String getBathrooms() {
		return bathrooms;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getRegion() {
		return region;
	}

	public String getPostcode() {
		return postcode;
	}

	public PropertyType getType() {
		return type;
	}

	/**
     * Creates builder to build {@link Property}.
     * 
     * @return created builder
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Builder to build {@link Property}.
     */
    public static final class Builder {
    	private String reference;
    	private String price;
    	private String bedrooms;
    	private String bathrooms;
    	private String houseNumber;
    	private String address;
    	private String region;
    	private String postcode;
    	private PropertyType type;

        private Builder() {  
        }
        
        /**
         * Build with the reference.
         * 
         * @param id, String representation of the property reference.
         * 
         * @return Builder
         */
        public Builder withReference(final String reference) {
            this.reference = reference;
            return this;
        }

        /**
         * Build with the price.
         * 
         * @param timestamp, String representation of the price.
         * 
         * @return Builder
         */
        public Builder withPrice(final String price) {
            this.price = price;
        	return this;
        }

        /**
         * Build with number of bedrooms.
         * 
         * @param bedrooms, String representation of the number of bedrooms.
         * 
         * @return Builder
         */
        public Builder withBedrooms(final String bedrooms) {
            this.bedrooms = bedrooms;
            return this;
        }

        /**
         * Build with the number bathrooms.
         * 
         * @param bathrooms, String representation of the number of bathrooms.
         * 
         * @return Builder
         */
        public Builder withBathrooms(final String bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        /**
         * Build with the houseNumber.
         * 
         * @param houseNumber, String representation of the houseNumber.
         * 
         * @return Builder
         */
        public Builder withHouseNumber(final String houseNumber) {
            this.houseNumber = houseNumber;
            return this;
        }

        /**
         * Build with the address.
         * 
         * @param address, String representation of the address.
         * 
         * @return Builder
         */
        public Builder withAddress(final String address) {
            this.address = address;
            return this;
        }

        /**
         * Build with the region.
         * 
         * @param region, String representation of the region.
         * 
         * @return Builder
         */
        public Builder withRegion(final String region) {
            this.region = region;
            return this;
        }

        /**
         * Build with the postcode.
         * 
         * @param postcode, String representation of the postcode.
         * 
         * @return Builder
         */
        public Builder withPostcode(final String postcode) {
            this.postcode = postcode;
            return this;
        }

        /**
         * Build with the type.
         * 
         * @param type, String representation of the type.
         * 
         * @return Builder
         */
        public Builder withType(final PropertyType type) {
            this.type = type;
            return this;
        }

        /**
         * Build Property
         * 
         * @return Property
         */
        public Property build() {
            return new Property(this);
        }
    }
}
