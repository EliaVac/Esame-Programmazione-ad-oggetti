package com.springboot.app.model;

import java.util.Calendar;

public class Exception {
	private String timestamp;
	private String status;
	private String error;
	private String message;
	/**
	 * @param status
	 * @param error
	 * @param message
	 */
	public Exception(String status, String error, String message) {
		super();
		this.timestamp= Calendar.getInstance().toString();
		this.status = status;
		this.error = error;
		this.message = message;
	}
	/**
	 * @return the timestamp
	 */
	public String getTimestamp() {
		return timestamp;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	
}
