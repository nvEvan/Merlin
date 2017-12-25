package com.revature.merlinserver.dao;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;

/**
 * 
 * @author Alex
 *
 */
public class PrivateInfoDao extends MerlinSessionDao<PrivateUserInfo> {
	
	public void update(PrivateUserInfo info) {
		
		session.update(info);
		
	}
	
	public void insert(PrivateUserInfo info) {
		session.save(info);
	}
	
	public PrivateUserInfo getPrivateUserInfo(MagicalUser user) {
		
		
		return null;
	}

}