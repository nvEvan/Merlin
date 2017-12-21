package com.revature.merlinserver.dao;

import java.util.List;

import org.hibernate.Session;

import com.revature.merlinserver.beans.BusinessObject;

/**
 * Defines specifications/requirements all Merlin Server daos must implement
 * @author Luie
 * @param <T>
 */
public interface MerlinDao<T extends BusinessObject> {
	
	/**
	 * Opens session
	 * @return true if session opens else false
	 */
	public boolean openSession();

	/**
	 * Enables transactions
	 * @return true if begun else false
	 */
	public boolean beginTransaction();
	
	/**
	 * Ends and commits transaction if transaction started
	 */
	public void endTransaction();
	
	/**
	 * Closes session if opened
	 */
	public void closeSession();
}
