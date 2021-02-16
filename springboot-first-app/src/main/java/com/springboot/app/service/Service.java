package com.springboot.app.service;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;

import com.springboot.app.model.Instruction;
import com.springboot.app.util.DatabaseCraft;
import com.springboot.app.util.InstructionCraft;
import com.springboot.app.model.Event;



@org.springframework.stereotype.Service
public class Service {
	private InstructionCraft istructioncraft = new InstructionCraft();
	private DatabaseCraft databasecraft = new DatabaseCraft();
	public ArrayList<Instruction> DisplayInstructions() {
		return istructioncraft.getInstructionsManual();
	}
	public ArrayList<Event> DisplayDatabase() throws IOException, JSONException{
		return databasecraft.getDatabase();
	}
}
