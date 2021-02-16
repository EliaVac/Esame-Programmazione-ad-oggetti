package com.springboot.app.service;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.springboot.app.model.Instruction;
import com.springboot.app.model.WrongFilter;
import com.springboot.app.util.DatabaseCraft;
import com.springboot.app.util.FilterExec;
import com.springboot.app.util.InstructionCraft;
import com.springboot.app.model.Event;



@org.springframework.stereotype.Service
public class Service {
	private InstructionCraft istructioncraft = new InstructionCraft();
	private DatabaseCraft databasecraft = new DatabaseCraft();
	private ArrayList<Event> database = new ArrayList<>();
	private FilterExec filterexec= new FilterExec(database);
	public Service() {
		try {
			database=databasecraft.getDatabase();
		} catch (IOException e) {
			e.printStackTrace();
			Exception exception = new Exception();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<Instruction> DisplayInstructions() {
		return istructioncraft.getInstructionsManual();
	}
	public ArrayList<Event> DisplayDatabase() throws IOException, JSONException{
		return database;
	}
	public ArrayList<Event> DisplayDatabase(JSONObject filter){
			return filterexec.Filter_executing(filter);
		}
	}

