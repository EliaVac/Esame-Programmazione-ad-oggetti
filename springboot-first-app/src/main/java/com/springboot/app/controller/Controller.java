package com.springboot.app.controller;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
