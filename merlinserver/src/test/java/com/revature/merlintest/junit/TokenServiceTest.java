package com.revature.merlintest.junit;

import org.junit.Ignore;
import org.junit.Test;
import org.testng.Assert;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.Token;
import com.revature.merlinserver.dao.MagicalUserDao;
import com.revature.merlinserver.service.TokenService;

/**
 * Test the functionality of TokenService
 * @author Alex
 */
public class TokenServiceTest {
	
	/**
	 * Create a token for a brand new user
	 */
	@Ignore
	public void createTokenTest() {
		MagicalUserDao magicalUserDao = new MagicalUserDao();
		MagicalUser user = null;
		Token token = null;
		
		magicalUserDao.open();
		user = magicalUserDao.getMagicalUserByUsername("alexp8");
		magicalUserDao.close();
		
		token = TokenService.createToken(user);
		Assert.assertNotNull(token);
		Assert.assertNotNull(token.getExpDate());
		
		token = TokenService.createToken(user);
		Assert.assertNotNull(token);
		Assert.assertNotNull(token.getExpDate());
		
	}
	
	/**
	 * Create a token for a user logging in test
	 */
	@Test
	public void createTokenForUserTest() {
		MagicalUserDao magicalUserDao = new MagicalUserDao();
		MagicalUser user = null;
		Token token = null;
		
		magicalUserDao.open();
		user = magicalUserDao.getMagicalUserByUsername("alexp8");
		magicalUserDao.close();
		
		token = TokenService.createTokenForUser(user);
		Assert.assertNotNull(token);
		Assert.assertNotNull(token.getExpDate());
	}
}