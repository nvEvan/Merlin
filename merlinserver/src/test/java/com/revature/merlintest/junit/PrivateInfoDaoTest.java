package com.revature.merlintest.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.dao.PrivateInfoDao;

/**
 * 
 * @author Alex
 *
 */
public class PrivateInfoDaoTest {
	
	@Test
	public void updateInfoTest() {
		PrivateInfoDao dao = new PrivateInfoDao();
		assertTrue(dao.open());
		
		PrivateUserInfo pf = new PrivateUserInfo();
		pf.setFirstName("bobbert");
		dao.insert(pf);
		
		pf.setFirstName("alex");
		dao.update(pf);
		dao.close();
		
		dao.open();
		
		
		
	}
}