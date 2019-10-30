package com.spring.globallogic.process;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilities {
		
	
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	private static final Pattern VALID_PASSWORD_REGEX = Pattern.compile("(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$");
	
		
	public boolean validateEmail(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(emailStr);
		return matcher.find();	
	}

	public boolean validatePassword(String passwordStr) {
		Matcher matcher = VALID_PASSWORD_REGEX .matcher(passwordStr);
		return matcher.find();	
	}
	
	

}
