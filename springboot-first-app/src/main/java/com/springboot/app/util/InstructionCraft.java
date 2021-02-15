package com.springboot.app.util;

import java.util.ArrayList;

import com.springboot.app.model.Instruction;

public class InstructionCraft {

	public ArrayList<Instruction> getInstructionsManual() {
		ArrayList<Instruction> total = new ArrayList<>();
		Instruction first = new Instruction("inizio1","fine1");
		total.add(first);
		Instruction second = new Instruction("inizio2","fine2");
		total.add(second);
		return total;
	}

}
