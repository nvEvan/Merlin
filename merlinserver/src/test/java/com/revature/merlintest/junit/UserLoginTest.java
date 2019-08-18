package com.revature.merlintest.junit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.junit.Test;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.dao.MagicalUserDao;

public class UserLoginTest {

	@Test
	public void test() {
		MagicalUserDao dao = new MagicalUserDao();
		MagicalUser user1, user2, user3, user4, user5;
		
		dao.open();
		
		user1 = dao.getMagicalUserByLogin("jcd", "bionicman");
		user2 = dao.getMagicalUserByLogin("big.boss", "the@nering@fP@wer");
		user3 = dao.getMagicalUserByLogin("evanwest", "EvanIsAwesome!");
		user4 = dao.getMagicalUserByLogin("alexp8", "1merlin!");
		user5 = dao.getMagicalUserByLogin("notAUser", "letMeIn");
		dao.close();
		
		assertNotNull(user1);
		assertNotNull(user2);
		assertNotNull(user3);
		assertNotNull(user4);
		assertEquals(user5, null);
		
	}

}
