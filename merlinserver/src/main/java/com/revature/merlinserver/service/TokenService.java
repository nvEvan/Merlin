package com.revature.merlinserver.service;

import java.util.UUID;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.Token;
import com.revature.merlinserver.dao.TokenDao;
import com.revature.util.DateUtil;

/**
 * Service methods needed for token creation, verification, and data retrieval involving tokens.
 * @author Alex
 */
public class TokenService {

	/**
	 * Creates a random token for a user.
	 * @param user
	 * @return the new token for that user
	 */
	public static Token createToken(MagicalUser user) {
		String tokenstr = UUID.randomUUID().toString();
		TokenDao td = new TokenDao();

		td.open();
		while (td.isTokenUnique(tokenstr) == 1) { //generate a token string that is unique
			System.out.println("token wasn't unique");
			tokenstr = UUID.randomUUID().toString();
		}
		td.close();

		return new Token(user, tokenstr, null); //return the new token object
	}

	/**
	 * This method accepts a string token and finds the user associated with the token.
	 * Returns null if there is no user with that token.
	 * @param token
	 * @return the user associated with the given token
	 */
	public static MagicalUser getUserByToken(String token) {
		TokenDao td = new TokenDao();
		MagicalUser user = null;

		td.open();
		user = td.getUserByToken(token); //grab the user by this token
		td.close();

		return user;
	}

	/**
	 * Update this user's token date to the current date.
	 * @param user to be updated
	 */
	public static void updateToken(MagicalUser user) {
		final TokenDao td = new TokenDao();
		Token token = null;
		java.util.Date date = null;
		java.sql.Date expDate = null;

		date = new java.util.Date();
		expDate = DateUtil.toDate(date.toString());

		td.open();
		token = td.getTokenByUser(user);
		token.setExpDate(expDate);
		td.updateToken(token);
		td.close();
	}
}
