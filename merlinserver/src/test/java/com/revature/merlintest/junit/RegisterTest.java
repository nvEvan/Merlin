package com.revature.merlintest.junit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.beans.Token;
import com.revature.merlinserver.dao.CodeListDao;
import com.revature.merlinserver.dao.MagicalUserDao;
import com.revature.merlinserver.dao.PrivateInfoDao;
import com.revature.merlinserver.dao.TokenDao;
import com.revature.merlinserver.paramwrapper.RegisterParams;
import com.revature.merlinserver.rest.Register;

public class RegisterTest {
	
	private static final String testUsername = "testbobbert";
	private PrivateUserInfo pui;
	private RegisterParams params;
	private MagicalUser user;
	private Register r;
	
	/**
	 * Insert a new test user into the RDS.
	 */
	@Before
	public void initialize() {
		r = new Register();
		user = new MagicalUser(testUsername, "123");
		CodeListDao cd = new CodeListDao();
		
		//pull some code lists for the private user info
		System.out.println("opening codelist session");
		cd.open();
		System.out.println("codelist session opened");
		CodeList stateCity = cd.getCodeListById(5); //California
		CodeList role = cd.getCodeListById(431); //pending
		CodeList status = cd.getCodeListById(424); //apprentice
		cd.close();
		
		pui = new PrivateUserInfo(user, role, stateCity, status, "Bobbert", "bobson", "merlintest@mail.com", "123145", "123 elm");
		params = new RegisterParams(user, pui);
	}
	
	/**
	 * Tests that a user was successfully registered.
	 */
	@Test
	public void registerTest() {
		r.register(params);
		
		MagicalUserDao md = new MagicalUserDao();
		PrivateInfoDao pd = new PrivateInfoDao();
		MagicalUser user = null;
		PrivateUserInfo pui = null;
		
		md.open();
		pd.setSession(md.getSession());
		user = md.getMagicalUserByUsername(testUsername);
		pui = pd.getPrivateInfoByUser(user);
		md.close();
		
		Assert.assertNotNull(user);
		Assert.assertNotNull(pui);
	}
	
	/**
	 * Delete the user from the RDS.
	 */
	@After
	public void cleanUp() {
		TokenDao td = new TokenDao();
		MagicalUserDao md = new MagicalUserDao();
		PrivateInfoDao pd = new PrivateInfoDao();
		PrivateUserInfo info = null;
		MagicalUser user = null;
		Token token = null;
		
		md.open();
		pd.setSession(md.getSession());
		td.setSession(md.getSession());
		user = md.getMagicalUserByUsername(testUsername);
		
		info = pd.getPrivateInfoByUser(user);
		
		pd.deletePriverUserInfoByUser(info);
		td.deleteToken(token);
		pd.commit();
		md.deleteUserByUsername(user);
		md.close();
	}
}
