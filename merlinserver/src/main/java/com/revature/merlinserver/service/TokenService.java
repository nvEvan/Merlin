package com.revature.merlinserver.service;

import java.util.UUID;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.Token;
import com.revature.merlinserver.dao.TokenDao;
import com.revature.util.DateUtil;

import oracle.sql.DATE;

/**
 * Service methods needed for token creation, verification, and data retrieval involving tokens.
 * @author Alex
 */
public class TokenService {
	/**The duration of user tokens will last 30 minutes.*/
	private static final int TOKEN_DURATION = 1800;

	/**
	 * Creates a random token for newly registered user.
	 * @param user
	 * @return the new token for that user
	 */
	public static Token createToken(final MagicalUser user) {
		String tokenstr = UUID.randomUUID().toString();
		TokenDao td = new TokenDao();
		Token token = null;
		
		td.open();
		while (td.isTokenUnique(tokenstr) == 1) { //generate a token string that is unique
			tokenstr = UUID.randomUUID().toString();
		}
		
		token = new Token(user, tokenstr, null);
		
		td.insertToken(token);
		td.close();

		return token; //return the new token object
	}
	
	/**
	 * Creates a new token for a user logging in.
	 * @param user
	 * @return to the user a new token
	 */
	public static Token createTokenForUser(final MagicalUser user) {
		String tokenstr = UUID.randomUUID().toString();
		TokenDao td = new TokenDao();
		Token token = null;
		java.util.Date date = null;
		java.sql.Date expDate = null;
		
		td.open();
		while (td.isTokenUnique(tokenstr) == 1) { //generate a token string that is unique
			tokenstr = UUID.randomUUID().toString();
		}
		
		date = new java.util.Date();
		expDate = new java.sql.Date(date.getTime());
		expDate.setTime(expDate.getTime() + TOKEN_DURATION);
		token = new Token(user, tokenstr, expDate); //set the user's expiration date
		
		td.insertToken(token); //persist the token
		td.close();

		return token; //return the new token object
	}

	/**
	 * This method accepts a string token and finds the user associated with the token.
	 * Returns null if there is no user with that token.
	 * @param token
	 * @return the user associated with the given token
	 */
	public static MagicalUser getUserByToken(final String token) {
		TokenDao td = new TokenDao();
		MagicalUser user = null;

		td.open();
		user = td.getUserByToken(token); //grab the user by this token
		td.close();

		return user;
	}
	
	/**
	 * Determines if token expired
	 * @param token - what to validate
	 * @return true is valid else false
	 */
	public static boolean isTokenValid(String token) {
		TokenDao td = new TokenDao();
		boolean result;
		
		// open session
		td.open();
		
		// validate token
		result = td.isTokenUnique(token) == 0;
		
		// close session
		td.close();
		
		return result;
	}
	
	/**
	 * Update this user's token expiration date.
	 * The expiration date will be 30 mins from the current time
	 * @param user to be updated
	 */
	public static void updateTokenByToken(String token) {
		final TokenDao td = new TokenDao();
		Token tkn = null;
		java.util.Date date = null;
		java.sql.Date expDate = null;
		long newExpDate;

		date = new java.util.Date();
		expDate = new java.sql.Date(date.getTime());
		
		newExpDate = expDate.getTime() + TOKEN_DURATION; //set the user's new expiration date to current time + 30 minutes
		expDate.setTime(newExpDate);
		
		td.open();
		tkn = td.getValidTokenByTokenString(token);
		tkn.setExpDate(expDate);
		td.updateToken(tkn); //update the token
		td.close();
	}
}