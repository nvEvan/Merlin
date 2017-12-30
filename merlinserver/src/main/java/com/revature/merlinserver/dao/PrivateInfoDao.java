package com.revature.merlinserver.dao;

import java.util.ArrayList;
import java.util.List;

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

	/**
	 * This method will return a list of all unverified adepts.
	 * @return
	 */
	public List<PrivateUserInfo> getAllUnverifiedAdepts() {
		List<PrivateUserInfo> unverifiedAdepts = null;
		
		if (isReady()) {
			Query q = null;
			unverifiedAdepts = new ArrayList<>();
			final int pendingId = 424; //id of codelist pending status
			final int adeptId = 430; //id of codelist adept role
			CodeList pendingStatus = null;
			CodeList roleStatus = null;
			
			//get the pending status codelist
			q = session.createQuery("FROM CodeList WHERE id = ?");
			q.setParameter(0, pendingId);
			pendingStatus = (CodeList) q.uniqueResult();
			
			//get the adept role codelist
			q = session.createQuery("FROM CodeList WHERE id = ?");
			q.setParameter(0, adeptId);
			roleStatus = (CodeList) q.uniqueResult();
			
			//get all adepts that are pending
			q = session.createQuery("FROM PrivateUserInfo WHERE status = ? && role = ?");
			q.setParameter(0, pendingStatus);
			q.setParameter(1, roleStatus);
			
			//add all of our unverified adepts to the list
			for (Object privateUserInfo : q.list()) {
				unverifiedAdepts.add((PrivateUserInfo) privateUserInfo);
			}
		}
		
		return unverifiedAdepts;
	}

	/**
	 * Approve an adept account.
	 * Set the adept's private user info status from 'PENDING' to 'ACTIVE'
	 * @param adept
	 */
	public void approveAdept(MagicalUser adept) {
		if (isReady()) {
			Query q = null;
			final int activeId = 425; //id of codelist active status
			CodeList activeStatus = null;
			PrivateUserInfo privateUserInfo = null;
			
			//get the active status codelist
			q = session.createQuery("FROM CodeList WHERE id = ?");
			q.setParameter(0, activeId);
			activeStatus = (CodeList) q.uniqueResult();
			
			//get the private user info
			q = session.createQuery("FROM PrivateUserInfo WHERE user = ?");
			q.setParameter(0, adept);
			privateUserInfo = (PrivateUserInfo) q.uniqueResult();
			
			privateUserInfo.setStatus(activeStatus); //set their status to active
			
			session.update(privateUserInfo);
		}
	}

	/**
	 * Return the pending status code list
	 * @param i
	 * @return
	 */
	public CodeList getStatusById(int id) {
		CodeList pendingStatus = null;
		
		if (isReady()) {
			Query q = null;
			
			//get the pending status codelist
			q = session.createQuery("FROM CodeList WHERE id = ?");
			q.setParameter(0, id);
			pendingStatus = (CodeList) q.uniqueResult();
		}
		return pendingStatus;
	}
}