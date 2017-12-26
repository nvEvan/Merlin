package com.revature.merlinserver.dao;

import java.util.List;

import org.hibernate.Query;

import com.revature.merlinserver.beans.IMThread;

/**
 * Used to acquire form thread information for user
 * @author Antony Lulciuc
 */
public class IMThreadDao extends MerlinSessionDao<IMThread> {
	
	/**
	 * Pulls all threads stored in DB
	 * @return List of IMThreads if data exists else null
	 */
	List<IMThread> loadAll() {
		List<IMThread> threads = null;
		
		// If connection ready load all threads 
		if (isReady()) {
			Query query = session.createQuery("FROM IMThread");
			threads = query.list();
		}
		
		return threads;
	}
}
