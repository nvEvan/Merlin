package com.revature.merlinserver.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PublicUserInfo;

/*
 * Dao for accessing public user information
 * @author Evan
 * 
 */
public class PublicInfoDao extends MerlinSessionDao<PublicUserInfo> {
	/**
	 * No-args constructor
	 */
	public PublicInfoDao() {
		// do nothing
	}

	/**
	 * Assigns a session to this dao
	 * 
	 * @param session
	 *            - session used to perform queries/transactions
	 */
	public PublicInfoDao(Session session) {
		super(session);
	}

	/**
	 * Insert a new PublicUserInfo object to the database
	 * 
	 * @param pui
	 *            - object to be inserted
	 */
	public void insert(PublicUserInfo pui) {
		if (isReady()) {
			session.save(pui);
		}
	}

	/**
	 * Fetch public user info by User
	 * @param user - MagicalUser object for which to fetch PublicInfo
	 */
	public PublicUserInfo getPublicUserInfoByUser(final MagicalUser user) {
		PublicUserInfo pui = null;

		if (isReady()) {
			Query q = null;

			q = session.createQuery("FROM PublicUserInfo WHERE user = ?");
			q.setParameter(0, user);

			pui = (PublicUserInfo) q.uniqueResult();
		}
		
		System.out.println("returning pui");
		System.out.println(pui);
		return pui;
		
	}

	/**
	 * Delete a PublicUserInfo object from the database
	 * 
	 * @param pui
	 *            - object to be deleted
	 */
	public void deletePublicInfoByObject(PublicUserInfo pui) {
		if (isReady()) {
			session.delete(pui);
		}
	}
	
	/**
	 * The methods takes in a user object. If it is valid it will return the user's
	 * public information, otherwise it will return null.
	 * @param user
	 * @return userInfo - users public information
	 */
	public PublicUserInfo getPublicInfoByUser(final MagicalUser user) {
		PublicUserInfo userinfo = null;

		if (isReady()) {
			Query q = null;

			q = session.createQuery("FROM PublicUserInfo WHERE user = ?");
			q.setParameter(0, user);
			userinfo = (PublicUserInfo) q.uniqueResult();
		} 

		return userinfo;
	}
	
	/**
	 * Takes in public information and updates the changes
	 * @param info
	 */
	public void update(final PublicUserInfo info){
		if(isReady()){
			session.update(info);
		}
	}
}
