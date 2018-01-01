package com.revature.merlintest.junit;

import static org.testng.Assert.assertEquals;

import org.junit.Test;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.dao.MagicalUserDao;
import com.revature.merlinserver.dao.PrivateInfoDao;

public class EditPrivateInfoTest {

	/**
	 * Test is to change the users name and back and dao is used to see if the changes
	 * were updated. If the test passes then users are able to update the changes they make
	 * to their private information.
	 */
	@Test
	public void test() {
		MagicalUserDao dao = new MagicalUserDao();
		PrivateInfoDao pd = new PrivateInfoDao();
		PrivateUserInfo info = null;
		MagicalUser user;
		String fname, lname;
		
		dao.open();
		pd.open();
		
		user = dao.getMagicalUserByLogin("jcd", "bionicman");
		fname = pd.getPrivateInfoByUser(user).getFirstName();
		lname = pd.getPrivateInfoByUser(user).getLastname();
		
		info = pd.getPrivateInfoByUser(user);
		
		info.setFirstName("John");
		info.setLastname("Doe");
		
		pd.update(info);
		
		assertEquals("John", pd.getPrivateInfoByUser(user).getFirstName());
		assertEquals("Doe", pd.getPrivateInfoByUser(user).getLastname());
		
		info.setFirstName(fname);
		info.setLastname(lname);
		
		pd.update(info);
		
		assertEquals(fname, pd.getPrivateInfoByUser(user).getFirstName());
		assertEquals(lname, pd.getPrivateInfoByUser(user).getLastname());
		
		dao.close();
		pd.close();
	}

}
