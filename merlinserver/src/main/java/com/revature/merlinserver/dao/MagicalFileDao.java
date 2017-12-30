package com.revature.merlinserver.dao;

import com.revature.merlinserver.beans.MagicalUser;

/**
 * 
 * @author Alex
 */
public class MagicalFileDao extends MerlinSessionDao<MagicalUser> {

	/**
	 * Persist the file bean
	 * @param magicalFileDao
	 */
	public void insertFile(final MagicalFileDao magicalFileDao) {
		if (isReady())
			session.save(magicalFileDao);
	}
	
	

}