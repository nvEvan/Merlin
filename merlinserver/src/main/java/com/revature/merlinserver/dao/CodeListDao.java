package com.revature.merlinserver.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.beans.MagicalUser;

/**
 * Access the database table CodeList here.
 * @author Alex
 */
public class CodeListDao extends MerlinSessionDao<MagicalUser> {
	
	/**
	 * No-args constructor
	 */
	public CodeListDao() {
		// do nothing
	}
	/**
	 * Assigns a session to this dao
	 * @param session - session used to perform queries/transactions 
	 */
	public CodeListDao(Session session) {
		super(session);
	}

	/**
	 * Finds the CodeList by its id.
	 * @param id of the codelist
	 * @return the codelist of the id or null of no codelist exists of that id
	 */
	public CodeList getCodeListById(final int id)  {
		CodeList cl = null;
		
		if (isReady()) {
			Query q = null;
			
			q = session.createQuery("FROM CodeList WHERE id = ?");
			q.setParameter(0, id);
			cl = (CodeList) q.uniqueResult();
		}
		
		return cl;
	}
	
	/**
	 * Return all of the codelists of a given code
	 * @return the list of codelists of that code
	 */
	public List<com.revature.merlinserver.beans.CodeList> getCodeListsByCode(final String code) {
		List<CodeList> states = null;
		
		if (isReady()) {
			Query q = null;
			states = new ArrayList<com.revature.merlinserver.beans.CodeList>();
			
			q = session.createQuery("FROM CodeList WHERE code = ?"); //grab codelists by certain code
			q.setParameter(0, code);
			
			for (Object state : q.list()) {
				states.add((CodeList) state);
			}
		}
		
		return states;
	}
}