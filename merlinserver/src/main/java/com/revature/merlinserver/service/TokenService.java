package com.revature.merlinserver.service;

import java.util.UUID;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.Token;
import com.revature.merlinserver.dao.TokenDao;

public class TokenService {

	/**
	 * 
	 * @param user
	 * @return
	 */
	public static Token createToken(MagicalUser user) {

		String tokenstr = UUID.randomUUID().toString();
		TokenDao td = new TokenDao();
		
		while (td.isTokenUnique(tokenstr) == false) {
			tokenstr = UUID.randomUUID().toString();
		}
		
		Token token = new Token(user, tokenstr, null);
		
		return token;
	}

	public static MagicalUser getUserByToken(String token) {
		TokenDao td = new TokenDao();
		td.open();
		MagicalUser user = td.getUserByToken(token);
		td.close();
		
		return user;
	}

	public static boolean tokenExistsAndIsNew(String token) {
		TokenDao td = new TokenDao();
		td.open();
		boolean unique = td.isTokenUnique(token);
		td.close();
		return unique;
	}
}