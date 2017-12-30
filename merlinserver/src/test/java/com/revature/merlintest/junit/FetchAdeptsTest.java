package com.revature.merlintest.junit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.testng.Assert;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.beans.PublicUserInfo;
import com.revature.merlinserver.dao.CodeListDao;
import com.revature.merlinserver.dao.MagicalUserDao;
import com.revature.merlinserver.dao.PublicInfoDao;
import com.revature.merlinserver.rest.FetchAdepts;

public class FetchAdeptsTest {
	private static final String testUsernamePrefix = "FetchAdeptTest_";
	private static final String testUsername = testUsernamePrefix + "user1";
	private PublicUserInfo pui;
	private MagicalUser user;
	private FetchAdepts fa;
	private int role_id;		//Used for checking fetched users roles are adept id's
	
	/**
	 * Insert test users into the database
	 */
	@Before
	public void initialize() {
		fa = new FetchAdepts();
		String firstName = "User"; 
		String lastName = "One";
		user = new MagicalUser(testUsername, "123");
		CodeListDao cd = new CodeListDao();
		
		//pull some code lists for the private user info
		cd.open();
		CodeList role = cd.getCodeListById(425); //Active
		cd.close();
		role_id = role.getId();
		
		pui = new PublicUserInfo(user, role, firstName, lastName, "merlintest@mail.com", "123-1234", "Address Placeholder", "A Description!!!", null);
		
		MagicalUserDao mud = new MagicalUserDao();
		PublicInfoDao pid = new PublicInfoDao();
		
		mud.open();
		pid.setSession(mud.getSession());
		mud.insertUser(user); //insert the new user
		pid.insert(pui); //insert the user's public info
		mud.close();
	}
	
//	@Before
//	public void insert_permanent_test_users() { 
//		//pull adept role code from code list
//		CodeListDao cd = new CodeListDao();
//		cd.open();
//		CodeList role = cd.getCodeListById(425); //Active
//		cd.close();
//		
//		MagicalUserDao mud = new MagicalUserDao();
//		PublicInfoDao pid = new PublicInfoDao();
//		mud.open();
//		for(int i = 0; i < 8; i++) {
//			String permanent_test_username = "AdeptTestUser_" + i;
//			String firstName = "firstname_" + i; 
//			String lastName = "lastname_" + i;
//			user = new MagicalUser(permanent_test_username, "123");
//			pui = new PublicUserInfo(user, role, firstName, lastName, "email@notAnEmail.com", "123-1234", "Address Placeholder", "A Description!!!", null);
//			
//			pid.setSession(mud.getSession());
//			mud.insertUser(user); //insert the new user
//			pid.insert(pui); //insert the user's public info
//		}
//		mud.close();
//		
//		Assert.assertTrue(true);
//	}
	
	/**
	 * Fetch all adepts and check that expected users are there
	 * And that other user roles are not present
	 */
	@Test
	public void FetchAndCheckUsers() {
		//Get adepts from the database
		List<PublicUserInfo> pui_list = fa.fetchAllAdepts();
		
		//Check that the test users are among those fetched
		//To-Do: Implement multiple test user functionality
		int actual_id = pui_list.get(0).getUser().getUserId();
		int expected_id = user.getUserId();
		Assert.assertEquals(actual_id, expected_id);
		
		//Check that all roles in the fetched results are Adept
		for(PublicUserInfo a_pui : pui_list) {
			int actaul_role_id = a_pui.getRole().getId();
			Assert.assertEquals(actaul_role_id, role_id);
		}
	}
	
	/*
	 * To-Do: 
	 * Test with no users in table
	 * Can we do this on the actual database?
	 */
	
	/**
	 * Clean the database after the test. Delete test users
	 */
	@After
	public void cleanUp() {
		MagicalUserDao mud = new MagicalUserDao();
		PublicInfoDao pid = new PublicInfoDao();
		mud.open();
		pid.setSession(mud.getSession());
		pid.deletePublicInfoByObject(pui);
//		pid.commit(); //This caused a unique constraints error on 2nd run. The user is not deleted from Magical User
		mud.deleteUserByUsername(user);
		mud.close();
	}
}
