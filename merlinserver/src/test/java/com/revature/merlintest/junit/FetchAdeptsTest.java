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

/**
 * Test the FetchAdept rest service
 * @author Evan
 *
 */
public class FetchAdeptsTest {
	private static final String testUsernamePrefix = "FetchAdeptTest_";
	private static final String testUsername = testUsernamePrefix + "userA";
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
		//Note: Not the most elegant way to run this test, but it works. 
		boolean user_exists = false; 
		int expected_id = user.getUserId();
		for(PublicUserInfo fetched_pui : pui_list) {
			int actual_id = fetched_pui.getUser().getUserId();
			if(expected_id == actual_id) {
				user_exists = true;
			}
		}
		Assert.assertTrue(user_exists);
		
		//Check that all roles in the fetched results are Adept
		for(PublicUserInfo a_pui : pui_list) {
			int actaul_role_id = a_pui.getRole().getId();
			Assert.assertEquals(actaul_role_id, role_id);
		}
	}
	
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
//		pid.commit(); //This caused a unique constraints error on 2nd run. The user is not deleted from Magical User table
		mud.deleteUserByUsername(user);
		mud.close();
	}
}
