package com.assignment.javaassign.service;

import org.springframework.stereotype.Service;


public interface UtilService {
	
	public boolean checkForUsernameValidation(String name);
	
	public boolean checkForPasswordValidation(String pass);

}
