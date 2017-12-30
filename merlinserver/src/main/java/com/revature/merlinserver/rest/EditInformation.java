package com.revature.merlinserver.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.dao.PrivateInfoDao;
import com.revature.merlinserver.dao.TokenDao;
import com.revature.merlinserver.paramwrapper.UserParam;
import com.revature.merlinserver.service.TokenService;

@Path("/Edit")
public class EditInformation {
	
	/**
	 * This method will consume a json object and will then set the new values as the 
	 * the edited values
	 * @author Nasir Alauddin
	 * @param userData
	 */
	@POST
	@Path("/MagicalPrivateInfo")
	@Consumes(MediaType.APPLICATION_JSON)
	public void editUser(UserParam userData){
		PrivateInfoDao pd = new PrivateInfoDao();
		
		pd.open();		
		pd.update(userData.getPrivateUserInfo());
		pd.close();
	}

}
