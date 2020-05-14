package com.assignment.javaassign.service;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class UtilServiceImpl implements UtilService {

	/**
	 * validation for username
	 */
	@Override
	public boolean checkForUsernameValidation(String name) {
		
		if(name != null && !name.isEmpty())
			return true;
		else
			return false;
		
	}

	/**
	 * validation for password
	 */
	@Override
	public boolean checkForPasswordValidation(String pass) {
		
		if(pass == null || pass.isEmpty() || pass.length()<8)
			return false;
		
		Pattern captial = Pattern.compile(".*[A-Z].*");
		Pattern small = Pattern.compile(".*[a-z].*");
		
		if(!captial.matcher(pass).matches())
			return false;
		
		if(!small.matcher(pass).matches())
			return false;
		
		return true;		
	}

}
