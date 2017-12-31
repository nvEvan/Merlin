package com.revature.merlinserver.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.merlinserver.beans.MagicalUser;
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
	 * Insert a new Review object to the database
	 * @param rev - object to be inserted
	 */
	public void insert(Review rev) {
		if(isReady()) {
			session.save(rev);
		}
	}
	
	/**
	 * Delete a Review object from the database
	 * @param rev - object to be deleted
	 */
	public void deletePublicInfoByObject(Review rev) {
		if(isReady()) {
			session.delete(rev);
		}
	}
	
	/**
	 * Fetch all reviews from the database
	 * @return List of reviews
	 */
	public List<Review> fetchAllReviews() {
		List<Review> revs = null;

		if (isReady()) {
			Query query = session.createQuery("FROM Review");
			revs = new ArrayList<>();

			for (Object rev : query.list()) {
				revs.add((Review) rev);
			}
		}

		return revs;
	}
	
}
