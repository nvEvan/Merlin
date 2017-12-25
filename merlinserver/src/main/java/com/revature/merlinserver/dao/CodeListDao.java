package com.revature.merlinserver.dao;

import org.hibernate.Query;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.beans.MagicalUser;

/**
 * 
 * @author Alex
 */
public class CodeListDao extends MerlinSessionDao<MagicalUser> {
	
	public CodeList getCodeListById(int id)  {
		CodeList cl = null;
		
		if (isReady()) {
			
			Query q = session.createQuery("FROM CodeList WHERE id = 425");
			cl = (CodeList) q.uniqueResult();
		}
		
		return cl;
	}
}