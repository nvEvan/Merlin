package com.revature.merlinserver.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.merlinserver.beans.BusinessObject;
import com.revature.util.HibernateUtil;

/**
 * Defines basic session and transaction creation and deletion methods
 * @author Antony Lulciuc
 * @param <T>
 */
public abstract class MerlinSessionDao<T extends BusinessObject> implements MerlinDao<T> {
	protected static Logger logger = Logger.getLogger(MerlinSessionDao.class);
	protected Session session;
	protected Transaction transaction;
	
	/**
	 * Flag used to determine if session was created by some external process. 
	 * If true, any open methods are ignored. 
	 * Close methods do not close session, but set session and flag to default values. 
	 * Allowing instance to create new session.
	 */
	private boolean isExternalSession;
	
	/**
	 * No-args constructor
	 */
	public MerlinSessionDao() {
	// do nothing	
	}
	
	/**
	 * Assigns a session to this dao
	 * @param session - session used to perform queries/transactions 
	 */
	public MerlinSessionDao(Session session) {
		setSession(session);
	}
	
	/**
	 * Assigns an existing session to the Data Access Object class 
	 * @param session - valid Hibernate Session
	 */
	public void setSession(Session session) {
		this.session = session;
		this.transaction = session.getTransaction();
		this.isExternalSession = true;
	}
	
	/**
	 * @return handle to valid session else null if no session instantiated 
	 */
	public Session getSession() {
		return session;
	}
	
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
	 * Commits all changes if transaction started
	 */
	public void commit() {
		if (isTransactionActive())
			transaction.commit();
	}
	
	/**
	 * Opens session
	 * @return true if session opens else false
	 */
	@Override
	public boolean openSession() {
		// Cannot create session if shared 
		if (isExternalSession)
			return false;
		
		try {
			// Ensure to free resources
			close();
			
			logger.debug("attempting to open session");
			
			// Attempt to open session
			session = HibernateUtil.getSession();
			logger.debug("open session successful");
		} catch (HibernateException e) {
			logger.fatal("failed to open session, message=" + e);
			e.printStackTrace();
			session = null;
		}
		
		return isSessionOpen();
	}

	/**
	 * Enables transactions
	 * @return true if begun else false
	 */
	@Override
	public boolean beginTransaction() {
		// Cannot begin transaction of external session
		if (isExternalSession)
			return false;
		
		endTransaction();
		
		// Ensure we have a valid session handle
		if (isSessionOpen())
			transaction = session.beginTransaction();
		
		return isTransactionActive();
	}

	/**
	 * Ends and commits transaction if transaction started
	 */
	@Override
	public void endTransaction() {
		// Only non-external sessions can commit changes 
		if (!isExternalSession && isTransactionActive()) 
			transaction.commit();
			
		transaction = null;
	}
	
	/**
	 * Closes session if opened
	 */
	@Override
	public void closeSession() {
		// Only session who instantiated session can close
		if (!isExternalSession && isSessionOpen()) 
			session.close();

		isExternalSession = false;
		session = null;
	}
	
	/**
	 * Determines if Dao has an open session
	 * @return true if open else false
	 */
	public boolean isSessionOpen() {
		return session != null && session.isConnected();
	}
	
	/**
	 * Determines if Dao has an open session
	 * @return true if open else false (if uses external session then returns true always)
	 */
	public boolean isTransactionActive() {
		return (transaction != null && transaction.isActive());
	}
	
	/**
	 * @return true if has handle to external session else false.s
	 */
	public boolean hasExternalSession() {
		return isExternalSession;
	}
	
	/**
	 * Determines if session and transaction is active
	 * @return true is session open and transaction started else false
	 */
	public boolean isReady() {
		return isSessionOpen() && isTransactionActive();
	}
	
	/**
	 * Fail-safe for closing sessions
	 */
	@Override
	protected void finalize() {
		close();
	}
}
