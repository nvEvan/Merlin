package com.revature.merlinserver.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.beans.PublicUserInfo;

/**
 * Performs SQL operations/transactions on MagicalUser Table
 * @author Antony Lulciuc
 */
public class MagicalUserDao extends MerlinSessionDao<MagicalUser> {

	/**
	 * No-args constructor
	 */
	public MagicalUserDao() {
		// do nothing
	}
	
	/**
	 * Assigns a session to this dao
	 * @param session - session used to perform queries/transactions 
	 */
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
	 * Loads MagicalUsers by role from database
	 * @return List of magical users matching the input role. Null if no users found
	 */
	public List<PublicUserInfo> loadUsersByRole(CodeList role) {
//		List<MagicalUser> users = null;
		List<PublicUserInfo> users = null;

		if (isReady()) {

//			Query query = session.createQuery("FROM MagicalUser");
			Query query = session.createQuery("FROM PublicUserInfo");
//			Query query_temp = session.createQuery("FROM MagicalUser INNER JOIN PRIVATEUSERINFO on MagicalUser.USER_ID = PRIVATEUSERINFO.PRIVATEUSERINFO_ID");
//			System.out.println(query_temp);
			
			users = new ArrayList<>();

			for (Object user : query.list()) {
//				users.add((MagicalUser) user);
				users.add((PublicUserInfo) user);
			}
		}
		
		System.out.println(role);

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
	public MagicalUser getMagicalUserById(final int id) {
		MagicalUser user = null;
		
		if (isReady()) {
			Query q = null;
			
			q = session.createQuery("FROM MagicalUser WHERE id = ?");
			q.setParameter(0, id);
			
			user = (MagicalUser) q.uniqueResult();
		}
		
		return user;
	}
	
	/**
	 * Find the magical user associated by a specific username
	 * @param username of the user being searched for
	 * @return null if no magical user exists of that username, or the user if a user is found of that username
	 */
	public MagicalUser getMagicalUserByUsername(final String username) {
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
	
	/**
	 * Enter the parameters of string username and password. The method searches for a MagicalUser
	 * who has those matching elements. If found we get out MagicalUser as our return object, otherwise
	 * we obtain a null.
	 * @param username
	 * @param password
	 * @return
	 */
	public MagicalUser getMagicalUserByLogin(final String username, final String password){
		MagicalUser user = null;
		
		if(isReady()) {
			Query q = null;
			
			// Write a query that searches a MagicalUser that contains a particular username and password
			q = session.createQuery("FROM MagicalUser WHERE username = ? AND password = ?");
			q.setParameter(0, username); // We set our username and password with the values of our parameter
			q.setParameter(1, password);
			
			user = (MagicalUser) q.uniqueResult();
		}
		
		return user;
	}
	
	/**
	 * updates the users information to table
	 * @param user
	 */
	public void update(final MagicalUser user){
		if(isReady()){
			session.update(user);
		}
	}
}