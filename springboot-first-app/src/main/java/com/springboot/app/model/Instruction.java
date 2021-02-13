package com.springboot.app.model;

public class Instruction {
	private String init;
	private String end;
	public Instruction(String init, String end) {
		super();
		this.init = init;
		this.end = end;
	}
	public String getInit() {
		return init;
	}
	public void setInit(String init) {
		this.init = init;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}	
}
