package com.revature.merlinserver.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;

/**
 * Dao class used to interact with the PrivateUserInfo table in the RDS.
 * @author Alex
 */
public class PrivateInfoDao extends MerlinSessionDao<PrivateUserInfo> {

	/**
	 * No-args constructor
	 */
	public PrivateInfoDao() {
		// do nothing
	}

	/**
	 * Assigns a session to this dao
	 * @param session - session used to perform queries/transactions 
	 */
	public PrivateInfoDao(Session session) {
		super(session);
	}

	/**
	 * Update a private user info.
	 * @param info
	 */
	public void update(final PrivateUserInfo info) {
		session.update(info);
	}

	/**
	 * Find the PrivateUserInfo associated with the given user.
	 * @param user wanting privateinfo of
	 * @return the private user info of a specific magical user
	 */
	public PrivateUserInfo getPrivateInfoByUser(final MagicalUser user) {
		PrivateUserInfo userinfo = null;

		if (isReady()) {
			Query q = null;
			
			q = session.createQuery("FROM PrivateUserInfo WHERE user = ?");
			q.setParameter(0, user);
			userinfo = (PrivateUserInfo) q.uniqueResult();
		} 

		return userinfo;
	}

	/**
	 * This method will check that the given user is a user that has not yet been verified.
	 * @param user to be checked
	 * @return true if the user is new
	 */
	public boolean isUserNew(final MagicalUser user) {
		boolean userIsNew = false;
		final int codelistStatusIDPending = 424;

		if (isReady()) {
			Query q = null;
			CodeList cl = null;
			
			q = session.createQuery("SELECT status FROM PrivateUserInfo WHERE user = ?"); //grab the status
			q.setParameter(0, user);
			cl = (CodeList) q.uniqueResult();
			
			userIsNew = cl.getId() == codelistStatusIDPending; //check if their account is PENDING
		}

		return userIsNew;
	}

	/**
	 * Insert a new user into the RDS
	 * @param pi
	 */
	public void insert(PrivateUserInfo pi) {
		if (isReady())
			session.save(pi);
	}

	/**
	 * Delete the given user's private info from the RDS.
	 * @param user
	 */
	public void deletePriverUserInfoByUser(PrivateUserInfo info) {
		if (isReady()) {
			session.delete(info);
		}
	}
}