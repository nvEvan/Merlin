package com.revature.merlinserver.dao;


import org.hibernate.Query;

import com.revature.merlinserver.beans.AdeptInfo;
import com.revature.merlinserver.beans.MagicalUser;

/**
 * Dao for interacting with AdeptInfo bean
 * @author Alex
 */
public class AdeptInfoDao extends MerlinSessionDao<MagicalUser> {

	/**
	 * Persist a new adept's info
	 * @param adeptInfo
	 */
	public void insert(AdeptInfo adeptInfo) {
		if (isReady()) {
			session.save(adeptInfo);
		}
	}
	
	/**
	 * Find a given adept's info 
	 * @param user
	 * @return
	 */
	public AdeptInfo getAdeptInfoByAdept(MagicalUser user) {
		AdeptInfo adeptInfo = null;
		if (isReady()) {
			Query q = session.createQuery("FROM AdeptInfo WHERE adept = ?");
			q.setParameter(0, user);
			adeptInfo = (AdeptInfo) q.uniqueResult();
		}
		return adeptInfo;
	}
}