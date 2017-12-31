package com.revature.merlinserver.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
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
	 * Fetch public user info by id
	 * @param id - integer containing id of adept to fetch from the database
	 */
	public PublicUserInfo getPublicUserInfoById(final int id) {
		PublicUserInfo pui = null;

		if (isReady()) {
			Query q = null;

			q = session.createQuery("FROM PublicUserInfo WHERE id = ?");
			q.setParameter(0, id);

			pui = (PublicUserInfo) q.uniqueResult();
		}

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

}
