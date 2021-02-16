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
		JSONObject fullObject = new JSONObject(data);
		JSONObject firstObject = (JSONObject)fullObject.get("_embedded");
		JSONArray dataArray = (JSONArray)firstObject.get("events");
		for(int i=0;i<dataArray.length();i++) {
			try {
			JSONObject info_event = (JSONObject)((JSONObject)dataArray.get(i)).get("_embedded");
			JSONArray venues = (JSONArray)info_event.get("venues");
			JSONObject info_geo_event = (JSONObject)venues.get(0);
			JSONArray classifications =(JSONArray)((JSONObject) dataArray.get(i)).get("classifications");
			JSONObject info_typ_event=(JSONObject)classifications.get(0);
			JSONObject info_dat_event=(JSONObject)(((JSONObject) ((JSONObject)dataArray.get(i)).get("dates")).getJSONObject("start"));
			String date= (String)info_dat_event.get("localDate");
			String time= (String)info_dat_event.get("localTime");
			String type= (String)((JSONObject)dataArray.get(i)).get("type");
			String genre= (String)((JSONObject)(info_typ_event.get("genre"))).get("name");
			String subgenre= (String)((JSONObject)(info_typ_event.get("subGenre"))).get("name");
			String region=(String)((JSONObject)dataArray.get(i)).get("locale");
			String state=(String)((JSONObject)info_geo_event.get("state")).get("name");
			String statecode=(String)((JSONObject)info_geo_event.get("state")).get("stateCode");
			String country=(String)((JSONObject)info_geo_event.get("country")).get("name");
			String countrycode=(String)((JSONObject)info_geo_event.get("country")).get("countryCode");
			String city=(String)((JSONObject)info_geo_event.get("city")).get("name");
			String address=(String)((JSONObject)info_geo_event.get("address")).get("line1");
			double longitude=Double.parseDouble((String)((JSONObject)info_geo_event.get("location")).get("longitude"));
			double latitude=Double.parseDouble((String)((JSONObject)info_geo_event.get("location")).get("latitude"));
			Event event=new Event(type, new Location(region, state, statecode, country, countrycode, city, address, longitude, latitude),genre,subgenre,date,time);
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
