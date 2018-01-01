package com.revature.merlinserver.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PublicUserInfo;
import com.revature.merlinserver.beans.Review;
import com.revature.merlinserver.dao.CodeListDao;
import com.revature.merlinserver.dao.MagicalUserDao;
import com.revature.merlinserver.dao.PublicInfoDao;
import com.revature.merlinserver.dao.ReviewDoa;
import com.revature.merlinserver.paramwrapper.FetchAdeptsParams;

/**
 * FetchAdepts --- Rest services for fetching data related to adepts
 * 
 * @author Evan West
 */
@Path("/fetch/adepts")
public class FetchAdepts {

	/**
	 * Fetch public information for all adepts from the database
	 * 
	 * @return List of PublicUserInfo objects
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FetchAdeptsParams> fetchAllAdepts() {
		//Get code list from database
		CodeListDao cld = new CodeListDao();
		cld.open();
		CodeList role = cld.getCodeListById(434); // Adepts
		cld.close();

		// Fetch users from the database
		MagicalUserDao mod = new MagicalUserDao();
		mod.open();
		List<PublicUserInfo> users = mod.loadUsersByRole(role);
		mod.close();
		
		ReviewDoa revd = new ReviewDoa(); 
		revd.open(); 
		List<Review> reviews = revd.fetchAllReviews();
		
		List<FetchAdeptsParams> return_list = new ArrayList<FetchAdeptsParams>();
		for(PublicUserInfo user : users) {
			float avg_review = 0; //initialize average to 0
			//Untested Review averaging code
//			for(Review rev : reviews) {
//				if(rev.getAdept().getUserId() == user.getUser().getUserId()) {
//					avg_review += rev.getScore();
//				}
//			}
			
			return_list.add(new FetchAdeptsParams(user, avg_review));
		}

		System.out.println(return_list);
		return return_list;
	}

	@POST
	@Path("/byId")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public PublicUserInfo fetchAdeptById(String adeptId) {				
		MagicalUserDao mod = new MagicalUserDao();
		PublicInfoDao pid = new PublicInfoDao();
		mod.open();
		pid.setSession(mod.getSession());
		MagicalUser myUser = mod.getMagicalUserById(Integer.parseInt(adeptId));
		PublicUserInfo pui = pid.getPublicUserInfoByUser(myUser);
		pid.close();
		
		return pui;
	}
}
