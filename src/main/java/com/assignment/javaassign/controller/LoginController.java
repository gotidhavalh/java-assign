package com.assignment.javaassign.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.javaassign.response.MessageResponse;
import com.assignment.javaassign.service.UtilServiceImpl;

/**
 * @author DGOTI
 *
 */

@RestController
public class LoginController {
	
	@Autowired
	private UtilServiceImpl service;

	@RequestMapping(path="/login", method = RequestMethod.POST)
	public ResponseEntity<MessageResponse> login(@RequestBody Map<String, String> payload) {
		
		String username = payload.get("username");
		String password = payload.get("password");
		
		boolean uName = service.checkForUsernameValidation(username);
		if(!uName)
			return new ResponseEntity<MessageResponse>(new MessageResponse("Enter Valid Username."), HttpStatus.BAD_REQUEST);
		
		boolean pass = service.checkForPasswordValidation(password);
		if(!pass)
			return new ResponseEntity<MessageResponse>(new MessageResponse("Enter Valid Password."), HttpStatus.BAD_REQUEST);
		
		
		return new ResponseEntity<MessageResponse>(new MessageResponse("Success"), HttpStatus.OK);
	}
	
}
