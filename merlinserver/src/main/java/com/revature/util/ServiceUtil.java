package com.revature.util;

import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.revature.merlinserver.beans.BusinessObject;

/**
 * Common methods used in Services 
 * @author Luie
 */
public class ServiceUtil {
	private static final String regexEmail = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	
	/**
	 * Ensures valid email supplied 
	 * @param email - what to check
	 * @return true if email valid else false
	 */
	public static boolean validateEmail(String email) {
		return email != null && email.matches(regexEmail);
	}
	
	/**
	 * Determines if string empty or null
	 * @param str - what to check
	 * @return true if string empty or null
	 */
	public static boolean isNullOrEmpty(String str) {
		return str == null || str.length() == 0;
	}
}
