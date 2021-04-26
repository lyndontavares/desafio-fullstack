package com.idomine.desafio.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailHelper {
	
	private EmailHelper() {
		
	}

	public static boolean isEmail(String email) {
		if ( !"".equals(email)) {
			String regex = "^([_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{1,6}))?$";
	        Pattern pattern = Pattern.compile(regex);
	        Matcher matcher = pattern.matcher(email);
	        return !matcher.matches();
		}
        return false;
	}
}
