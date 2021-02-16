package com.springboot.app.model;

import java.util.ArrayList;

public class Event {
	private String type;
	private String genre;
	private String subgenre;
	private Date date;
	private Location location;
	/**
	 * @param type
	 * @param location
	 * @param genre
	 * @param subgenre
	 */
	public Event(String type, Location location, String genre, String subgenre,String date,String time) {
		super();
		this.type = type;
		this.genre = genre;
		this.subgenre = subgenre;
		this.location = location;
		this.date=new Date(date,time);
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @return the subgenre
	 */
	public String getSubgenre() {
		return subgenre;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date.toString();
	}
	
}
