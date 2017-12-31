package com.revature.merlinserver.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.beans.AdeptInfo;
import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.beans.PublicUserInfo;
import com.revature.merlinserver.dao.CodeListDao;
import com.revature.merlinserver.dao.MagicalUserDao;

/**
 * FetchAdepts --- Rest services for fetching data related to adepts
 * @author Evan West
 */
@Path("/fetch/adepts")
public class FetchAdepts {	
	
	/**
	 * Fetch public information for all adepts from the database
	 * @return List of PublicUserInfo objects
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PublicUserInfo> fetchAllAdepts() {
		//Get code list from database
		CodeListDao cld = new CodeListDao();
		cld.open();
		CodeList role = cld.getCodeListById(434); //Adepts
		cld.close();
		
		//Fetch users from the database
		MagicalUserDao mod = new MagicalUserDao();
		mod.open();
		List<PublicUserInfo> users = mod.loadUsersByRole(role);
		mod.close();

		System.out.println(users);
		return users;
	}

}
