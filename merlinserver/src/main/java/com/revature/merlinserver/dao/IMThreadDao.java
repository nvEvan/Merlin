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
	 * Attempts to locate thread by name
	 * @param name - title of thread
	 * @return IMThread if found else null
	 */
	public IMThread findIMThreadByName(String name) {
		IMThread thread = null;
		
		if (isReady()) {
			Query query = session.createQuery("FROM IMThread WHERE name = ?");
			
			// set thread data 
			query.setParameter(0, name);
			
			// atempt to get threead
			thread = (IMThread)query.uniqueResult();
		}
		
		return thread;
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
	
	/**
	 * Deletes thread by thread id
	 * @param id - thread identifier
	 * @return true if deleted else false
	 */
	public boolean deleteIMThreadById(Integer id) {
		boolean result = false;
		
		if (isReady()) {
			Query query = session.createQuery("FROM IMThread WHERE id = ?");
			IMThread thread;
			
			// set params
			query.setParameter(0, id);
			
			// get data
			thread = (IMThread)query.uniqueResult();
			result = thread != null;
			
			// if found
			if (result)
				session.delete(thread);
		}
		
		return result;
	}
	
	///
	//	PRIVATE METHODS
	///
	
	/**
	 * Determines if thread has all data needed before inserted
	 * @param thread - what to check
	 * @return true if valid else false
	 */
	private boolean hasValidData(IMThread thread) {
		boolean result = thread != null;
		
		// Validate new IMThread instance data
		result = result && thread.getCreator() != null;
		result = result && !ServiceUtil.isNullOrEmpty(thread.getLink());
		result = result && !ServiceUtil.isNullOrEmpty(thread.getName());
		result = result && thread.getThreadCreationDate() != null;
		
		return result;
	}
}
