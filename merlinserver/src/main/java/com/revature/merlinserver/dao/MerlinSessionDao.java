package com.revature.merlinserver.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.merlinserver.beans.BusinessObject;

/**
 * Defines basic session and transaction creation and deletion methods
 * @author Luie
 * @param <T>
 */
public abstract class MerlinSessionDao<T extends BusinessObject> implements MerlinDao<T> {
	protected Session session;
	protected Transaction transaction;
	
	/**
	 * Opens and begins transaction in one step
	 * @return true if session and transaction started else false
	 */
	public boolean open() {
		// Attempt to open session and begin transactions 
		if (!openSession() || !beginTransaction()) {
			close();
			return false;
		}
		
		return true;
	}
	
	/**
	 * Closes session and commits transactions in one step
	 */
	public void close() {
		endTransaction();
		closeSession();
	}
	
	/**
	 * Opens session
	 * @return true if session opens else false
	 */
	@Override
	public boolean openSession() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Enables transactions
	 * @return true if begun else false
	 */
	@Override
	public boolean beginTransaction() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ends and commits transaction if transaction started
	 */
	@Override
	public void endTransaction() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Closes session if opened
	 */
	@Override
	public void closeSession() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Fail-safe for closing sessions
	 */
	@Override
	protected void finalize() {
		close();
	}
}
