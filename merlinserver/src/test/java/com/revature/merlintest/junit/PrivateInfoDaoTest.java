package com.revature.merlintest.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.merlinserver.dao.PrivateInfoDao;

public class PrivateInfoDaoTest {
	
	@Test
	public void shouldLoadAllUsers() {
		PrivateInfoDao dao = new PrivateInfoDao();
		
		assertTrue(dao.open());
//		assertNotNull(dao.update());
		dao.close();
	}
}