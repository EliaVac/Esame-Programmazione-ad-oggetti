package com.springboot.app.service;

import java.util.ArrayList;
import com.springboot.app.model.Instruction;
import com.springboot.app.util.IstructionCraft;


@org.springframework.stereotype.Service
public class Service {
	private IstructionCraft istructioncraft = new IstructionCraft();
	public ArrayList<Instruction> DisplayInstructions() {
		return istructioncraft.getInstructionsManual();
	}
}
