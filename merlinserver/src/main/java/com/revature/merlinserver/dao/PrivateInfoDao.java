package com.revature.merlinserver.dao;

import org.hibernate.Query;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;

/**
 * 
 * @author Alex
 */
public class PrivateInfoDao extends MerlinSessionDao<PrivateUserInfo> {
	
	/**
	 * Update a private user info.
	 * @param info
	 */
	public void update(PrivateUserInfo info) {
		
		session.update(info);
		
	}
	
	/**
	 * @param user
	 * @return the private user info of a specific magical user
	 */
	public PrivateUserInfo getPrivateInfoByUser(MagicalUser user) {
		PrivateUserInfo userinfo = null;
		
		if (isReady()) {

			Query q = session.createQuery("FROM PrivateUserInfo WHERE user = ?");
			q.setParameter(1, user);

			userinfo = (PrivateUserInfo) q.uniqueResult();
		} 
		
		return userinfo;
	}
}