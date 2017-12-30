package com.revature.merlinserver.dao;

import java.sql.Date;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.Token;
import com.revature.util.DateUtil;

/**
 * Dao for the Token bean.
 * All interactions with the DB Token table are here.
 * @author Alex
 */
public class TokenDao extends MerlinSessionDao<MagicalUser> {

	/**
	 * No-args constructor
	 */
	public TokenDao() {
		// do nothing
	}
	
	/**
	 * Assigns a session to this dao
	 * @param session - session used to perform queries/transactions 
	 */
	public TokenDao(Session session) {
		super(session);
	}

	/**
	 * Insert the new token into the Token table.
	 * @param token
	 */
	public void insertToken(final Token token) {
		if (isReady()) {
			session.save(token);
		}
	}

	/**
	 * Update the given token.
	 * @param token
	 */
	public void updateToken(final Token token) {
		if (isReady()) {
			session.update(token);
		}
	}

	/**
	 * This method checks that a given token has not been assigned to a user yet.
	 * @param tokenstr
	 * @return 0 if the token is unique, 1 if the the token is not unique, and 2 we were unable to connect to the RDS
	 */
	public int isTokenUnique(final String tokenstr) {
		Token token = null;

		if (isReady()) {
			Query q = null;
			
			//search the table for tokens 
			q = session.createQuery("FROM Token WHERE token = ? AND (expDate IS NULL OR expDate > ?)");
			q.setParameter(0, tokenstr);
			q.setParameter(1, new Date(new java.util.Date().getTime()));
			
			token = (Token) q.uniqueResult();
			
			return token == null ? 0 : 1;
		} else {
			return 2;
		}
	}

	/**
	 * Each user has a unique token, this method will find the user of the given token.
	 * If no user has the token, return null.
	 * @param token
	 * @return the user associated with the given token
	 */
	public MagicalUser getUserByToken(final String token) {
		MagicalUser user = null;
		
		if (isReady()) {
			Query q = null;
			
			q = session.createQuery("SELECT user FROM Token WHERE token = ?");
			q.setParameter(0, token);

			user = (MagicalUser) q.uniqueResult();
		} 

		return user;
	}
	
	/**
	 * Find the token associated with the given user.
	 * @param user
	 * @return the token of said user
	 */
	public Token getTokenByUser(final MagicalUser user) {
		Token token = null;
		
		if (isReady()) {
			Query q = null;
			
			q = session.createQuery("FROM Token WHERE user = ?");
			q.setParameter(0, user);

			token = (Token) q.uniqueResult();
		}
		
		return token;
	}
	
	/**
	 * Delete a given token from the RDS.
	 * @param token
	 */
	public void deleteToken(Token token) {
		if (isReady()) {
			session.delete(token);
		}
	}
}
