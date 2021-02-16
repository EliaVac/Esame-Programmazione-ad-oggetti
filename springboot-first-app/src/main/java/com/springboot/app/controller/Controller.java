package com.springboot.app.controller;

import java.io.IOException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.model.Event;
import com.springboot.app.model.ExceptionClass;
import com.springboot.app.model.WrongFilter;
import com.springboot.app.service.Service;

@RestController
public class Controller {
	@Autowired
	private Service service;

	@GetMapping("/GetInstructions")
	public ResponseEntity<Object> getInstruction() {
		return new ResponseEntity<>(service.DisplayInstructions(), HttpStatus.OK);
	}

	@GetMapping("/GetDatabase")
	public ResponseEntity<Object> getDatabase() throws IOException, JSONException {
		return new ResponseEntity<>(service.DisplayDatabase(), HttpStatus.OK);
	}
	
	@PostMapping("/GetDatabase")
	public ResponseEntity<Object> getDatabase(@RequestBody JSONObject filter)  {
		return new ResponseEntity<>(service.DisplayDatabase(filter), HttpStatus.OK);
	}
	
	@ExceptionHandler(WrongFilter.class)
	public final ResponseEntity<ExceptionClass> exception(Exception e){
		ExceptionClass error = new ExceptionClass(null, null, null);
		return new ResponseEntity<ExceptionClass>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST );
	}
	
}
