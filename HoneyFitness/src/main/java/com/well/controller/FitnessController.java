package com.well.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.well.bean.User;


@RestController
@RequestMapping("/fitnessApi")
public class FitnessController {

	
	
	@PostMapping(value="/login",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> login(@RequestBody User user) {
		
		System.out.println("user details "+user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
}
	