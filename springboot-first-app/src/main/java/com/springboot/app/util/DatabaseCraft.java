package com.springboot.app.util;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;

import com.springboot.app.model.Event;

public class DatabaseCraft {
	public ArrayList<Event> getDatabase() throws IOException, JSONException {
		ArrayList<Event> database = new ArrayList<>();
		StringBuilder content = new StringBuilder();
		try {
			URL url = new URL("https://app.ticketmaster.com/discovery/v2/events.json?countryCode=US&apikey=JG0IW5CN7ztN9QAuDWjF3PFTyetbLtoG");
			URLConnection urlConnection = url.openConnection();
			BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			String line;
			do{
				line = br.readLine();
				if(line!=null)
					content.append(line + "\n");
			}while(line!=null);
						br.close();
			JSONArray databaseArray = new JSONArray(line);
		}finally {
			
		}
		return database;
	}
 }
