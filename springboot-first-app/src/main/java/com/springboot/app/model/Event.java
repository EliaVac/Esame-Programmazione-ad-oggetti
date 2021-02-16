package com.springboot.app.model;

public class Event {
	private String type;
	private Location location;
	/**
	 * @param type
	 * @param location
	 */
	public Event(String type, Location location) {
		super();
		this.type = type;
		this.location = location;
	}

}
