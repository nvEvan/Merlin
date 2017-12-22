package com.revature.merlintest.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.revature.merlinserver.dao.MagicalUserDao;

public class MagicalUserDaoTest {

	@Test
	public void shouldLoadAllUsers() {
		MagicalUserDao dao = new MagicalUserDao();
		
		
		assertTrue(dao.open());
		assertNotNull(dao.loadAll());
		
		dao.close();
	}
}
