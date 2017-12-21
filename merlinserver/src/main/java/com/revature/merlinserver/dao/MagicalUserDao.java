package com.revature.merlinserver.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;

import com.revature.merlinserver.beans.MagicalUser;

/**
 * Performs SQL operations/transactions on MagicalUser Table
 * @author Luie
 */
public class MagicalUserDao extends MerlinSessionDao<MagicalUser> {
	
	/**
	 * Loads all MagicalUsers from database
	 * @return List of magical users if found else null
	 */
	public List<MagicalUser> loadAll() {
		List<MagicalUser> users = null;
		
		if (isReady()) {
			Query query = session.createQuery("FROM MagicalUser");
			users = query.list();
		}
		
		return users;
	}
}
