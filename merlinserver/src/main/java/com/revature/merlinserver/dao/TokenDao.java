package com.revature.merlinserver.dao;

import java.util.Date;

import org.hibernate.Query;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.Token;
import com.revature.util.DateUtil;

public class TokenDao extends MerlinSessionDao<MagicalUser> {
	
	public void insertToken(Token token) {
		
		if (isReady()) {
			
			
		}
	}
	
	public void updateToken(Token token) {
		
		
		
	}
	
	public Token getTokenById(int id) {
		
		
		return null;
	}

	/**
	 * 
	 * @param tokenstr
	 * @return
	 */
	public boolean isTokenValid(MagicalUser user, String tokenstr) {
		
		if (isReady()) {
			
			Query q = session.createQuery("FROM TOKEN WHERE token = ? AND expDate > ?");
			q.setParameter(1, tokenstr);
			
			java.util.Date date = new java.util.Date();
			java.sql.Date sqlDate = DateUtil.toDate(date.toString());
			
			q.setParameter(2, sqlDate);
			
			Token token = (Token) q.uniqueResult();
			
			if (token != null) {
				return false;
			} else {
				return true;
			}
		} else {
			return false;
		}
	}
}