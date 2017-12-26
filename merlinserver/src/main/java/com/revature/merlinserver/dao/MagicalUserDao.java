package com.revature.merlinserver.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.merlinserver.beans.MagicalUser;

/**
 * Performs SQL operations/transactions on MagicalUser Table
 * @author Luie
 */
public class MagicalUserDao extends MerlinSessionDao<MagicalUser> {

	public MagicalUserDao() {
		
	}
	
	public MagicalUserDao(Session session) {
		super(session);
	}
	
	/**
	 * Loads all MagicalUsers from database
	 * @return List of magical users if found else null
	 */
	public List<MagicalUser> loadAll() {
		List<MagicalUser> users = null;

		if (isReady()) {
			Query query = session.createQuery("FROM MagicalUser");
			users = new ArrayList<>();

			for (Object user : query.list()) {
				users.add((MagicalUser) user);
			}
		}

		return users;
	}

	/**
	 * Insert a new user into the RDS.
	 * @param user
	 */
	public void insertUser(final MagicalUser user) {
		if (isReady())
			session.save(user);
	}
	
	/**
	 * Find the magical user associated by a specific Id
	 * @param id
	 * @return null if no magical user exists of that id, or the user if a user is found of that id
	 */
	public MagicalUser getMagicalUserById(final String username) {
		MagicalUser user = null;
		
		if (isReady()) {
			Query q = null;
			
			q = session.createQuery("FROM MagicalUser WHERE username = ?");
			q.setParameter(0, username);
			
			user = (MagicalUser) q.uniqueResult();
		}
		
		return user;
	}

	/**
	 * Delete a given magical user from the RDS.
	 * @param user
	 */
	public void deleteUserByUsername(MagicalUser user) {
		if (isReady()) {
			session.delete(user);
		}
	}
}