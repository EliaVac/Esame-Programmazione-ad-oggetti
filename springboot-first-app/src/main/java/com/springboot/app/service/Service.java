package com.springboot.app.service;

import java.util.ArrayList;
import com.springboot.app.model.Instruction;
import com.springboot.app.util.InstructionCraft;


@org.springframework.stereotype.Service
public class Service {
	private InstructionCraft istructioncraft = new InstructionCraft();
	public ArrayList<Instruction> DisplayInstructions() {
		return istructioncraft.getInstructionsManual();
	}
}
