package com.revature.merlinserver.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.dao.MagicalUserDao;
import com.revature.merlinserver.dao.PrivateInfoDao;
import com.revature.merlinserver.dao.PublicInfoDao;
import com.revature.merlinserver.paramwrapper.UserParam;

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
		MagicalUserDao dao = new MagicalUserDao();
		PrivateInfoDao pd = new PrivateInfoDao();
		PublicInfoDao pubDao = new PublicInfoDao();
		
		dao.open();
		pd.open();
		pubDao.open();
		
		dao.update(userData.getUser());
		
		if(userData.getPublicInfo()!=null){
			if(pubDao.getPublicInfoByUser(userData.getUser()) != null)
				pubDao.update(userData.getPublicInfo());
			else
				pubDao.insert(userData.getPublicInfo());
		}
		
		if(userData.getPrivateUserInfo()!=null){
			if(pd.getPrivateInfoByUser(userData.getUser()) != null)
				pd.update(userData.getPrivateUserInfo());
			else
				pd.insert(userData.getPrivateUserInfo());
		}
		
		dao.close();
		pd.close();
		pubDao.close();
	}

}
