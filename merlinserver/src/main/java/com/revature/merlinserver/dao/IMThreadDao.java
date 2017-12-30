package com.revature.merlinserver.dao;

import java.util.List;

import org.hibernate.Query;

import com.revature.merlinserver.beans.IMThread;
import com.revature.util.ServiceUtil;

/**
 * Used to acquire form thread information for user
 * @author Antony Lulciuc
 */
public class IMThreadDao extends MerlinSessionDao<IMThread> {
	
	/**
	 * Pulls all threads stored in DB
	 * @return List of IMThreads if data exists else null
	 */
	public List<IMThread> loadAll() {
		List<IMThread> threads = null;
		
		// If connection ready load all threads 
		if (isReady()) {
			Query query = session.createQuery("FROM IMThread");
			threads = query.list();
		}
		
		return threads;
	}
	
	/**
	 * Inserts a instant message thread if session opened 
	 * @param thread - what to insert
	 * @returns 1 on successful insert else 0 
	 */
	public int insertIMThread(IMThread thread) {
		// Ensure session and thread info is ready for processing
		if (isReady() && hasValidData(thread)) {
			session.save(thread);
			return 1;
		}
		
		return 0;
	}
	
	
	///
	//	PRIVATE METHODS
	///
	
	private boolean hasValidData(IMThread thread) {
		boolean result = thread == null;
		
		// Validate new IMThread instance data
		result = result && thread.getCreator() != null;
		result = result && !ServiceUtil.isNullOrEmpty(thread.getLink());
		result = result && !ServiceUtil.isNullOrEmpty(thread.getName());
		result = result && thread.getThreadCreationDate() != null;
		
		return result;
	}
}
