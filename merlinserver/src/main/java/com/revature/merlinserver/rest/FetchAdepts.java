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
import com.revature.merlinserver.paramwrapper.RegisterParams;

/*
 * FetchAdepts --- Class to facilicate the fetching of adepts
 * @author Evan West
 */
@Path("/fetch/adepts")
public class FetchAdepts {	
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PublicUserInfo> fetchAllAdepts() {
		// pull some code lists for the private user info
		CodeListDao cld = new CodeListDao();
		System.out.println("opening codelist session");
		cld.open();
		System.out.println("codelist session opened");
//		CodeList role = cld.getCodeListById(429); //Admins
		CodeList role = cld.getCodeListById(430); //Tutors
		cld.close();

		MagicalUserDao mod = new MagicalUserDao();
		mod.open();
		List<PublicUserInfo> users = mod.loadUsersByRole(role);
		mod.close();

		System.out.println(users);
		return users;
	}

}
