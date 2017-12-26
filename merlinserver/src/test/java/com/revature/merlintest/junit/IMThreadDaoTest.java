package com.revature.merlintest.junit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.merlinserver.beans.IMThread;
import com.revature.merlinserver.dao.IMThreadDao;

public class IMThreadDaoTest {
	IMThreadDao dao = new IMThreadDao();
	IMThread thread;
	
	@Before
	public void setUp() throws Exception {
		thread = new IMThread();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void loadAllThreads() {
		assertTrue(dao.open());
		assertNotNull(dao.loadAll());
		dao.close();
	}

}
