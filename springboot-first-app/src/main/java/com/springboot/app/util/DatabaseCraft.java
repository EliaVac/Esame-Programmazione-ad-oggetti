package com.springboot.app.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.springboot.app.model.Event;
import com.springboot.app.model.Location;

public class DatabaseCraft {
	private String urlString = "https://app.ticketmaster.com/discovery/v2/events.json?countryCode=US&apikey=JG0IW5CN7ztN9QAuDWjF3PFTyetbLtoG";
	public ArrayList<Event> getDatabase() throws IOException, JSONException {
		ArrayList<Event> database = new ArrayList<>();
		String data =StringRequest();
		if(data!=null) {
		JSONObject databaseObject = new JSONObject(data);
		JSONObject dataObject = (JSONObject)databaseObject.get("_embedded");
		JSONArray dataArray = (JSONArray)dataObject.get("events");
		for(int i=0;i<dataArray.length();i++) {
			try {
			JSONObject event1 = (JSONObject)((JSONObject)dataArray.get(i)).get("_embedded");
			JSONArray venues = (JSONArray)event1.get("venues");
			JSONObject event2 = (JSONObject)venues.get(0);
			String region=(String)((JSONObject)dataArray.get(i)).get("locale");
			String state=(String)((JSONObject)event2.get("state")).get("name");
			String statecode=(String)((JSONObject)event2.get("state")).get("stateCode");
			String country=(String)((JSONObject)event2.get("country")).get("name");
			String countrycode=(String)((JSONObject)event2.get("country")).get("countryCode");
			String city=(String)((JSONObject)event2.get("city")).get("name");
			String address=(String)((JSONObject)event2.get("address")).get("line1");
			double longitude=(double)((JSONObject)event2.get("location")).get("longitude");
			double latitude=(double)((JSONObject)event2.get("location")).get("latitude");
			Event event=new Event(address, new Location(region, state, statecode, country, countrycode, city, address, longitude, latitude));
			database.add(event);
			}catch (Exception e){
				continue;
			}
		}
		return database;
		}
		return null;
	}

	private String StringRequest() {
		StringBuilder content = new StringBuilder();
		try {
			URL url = new URL(urlString);
			URLConnection urlConnection = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line = null;
			while((line = br.readLine())!=null) {
				content.append(line + "\n");
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}
}
