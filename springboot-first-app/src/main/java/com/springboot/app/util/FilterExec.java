package com.springboot.app.util;

import java.util.ArrayList;

import org.json.JSONObject;

import com.springboot.app.model.Event;
import com.springboot.app.model.WrongFilter;

public class FilterExec {
	private ArrayList<Event> database;
	private JSONObject filter;

	public FilterExec(ArrayList<Event> database) {
		this.database = database;
	}

	public ArrayList<Event> Filter_executing(JSONObject filter) {
		ArrayList<Event> databasefiltered = new ArrayList<>();
		boolean validity = true; // true -> both	// false -> almost_one
		ArrayList<Event> DBF_region = new ArrayList<>();
		ArrayList<Event> DBF_type = new ArrayList<>();
		ArrayList<Event> DBF_genre = new ArrayList<>();
		ArrayList<Event> DBF_date = new ArrayList<>();
		return databasefiltered;
	}
}
