package com.revature.merlinserver.dao;

import org.hibernate.Session;

import com.revature.merlinserver.beans.PublicUserInfo;
import com.revature.merlinserver.beans.Review;

/**
 * Fetch data related to reviews
 * @author Evan
 *
 */
public class ReviewDoa extends MerlinSessionDao<PublicUserInfo> {
	/**
	 * No-args constructor
	 */
	public ReviewDoa() {
		// do nothing
	}

	/**
	 * Assigns a session to this dao
	 * @param session - session used to perform queries/transactions 
	 */
	public ReviewDoa(Session session) {
		super(session);
	}
	
	/**
	 * Insert a new PublicUserInfo object to the database
	 * @param pui - object to be inserted
	 */
	public void insert(Review rev) {
		if(isReady()) {
			session.save(rev);
		}
	}
	
	/**
	 * Delete a PublicUserInfo object from the database
	 * @param pui - object to be deleted
	 */
	public void deletePublicInfoByObject(Review rev) {
		if(isReady()) {
			session.delete(rev);
		}
	}
}
