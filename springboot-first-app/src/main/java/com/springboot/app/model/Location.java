package com.springboot.app.model;

public class Location {
	private String region;
	private String state;
	private String statecode;
	private String country;
	private String countrycode;
	private String city;
	private String address;
	private double longitude;
	private double latitude;
	/**
	 * @param region
	 * @param state
	 * @param statecode
	 * @param country
	 * @param countrycode
	 * @param city
	 * @param address
	 * @param longitude
	 * @param latitude
	 */
	public Location(String region, String state, String statecode, String country, String countrycode, String city,
			String address, double longitude, double latitude) {
		super();
		this.region = region;
		this.state = state;
		this.statecode = statecode;
		this.country = country;
		this.countrycode = countrycode;
		this.city = city;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	

}
