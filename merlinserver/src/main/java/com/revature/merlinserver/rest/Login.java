package com.revature.merlinserver.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.dao.MagicalUserDao;
import com.revature.merlinserver.dao.PrivateInfoDao;
import com.revature.merlinserver.paramwrapper.UserParam;
import com.revature.merlinserver.service.TokenService;

/**
 * TODO : do login validation and other stuff
 * @author Luie
 */
@Path("/login")
public class Login {
	
	// Obtain user's user info and private info
	@POST
	@Path("/MagicalUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public UserParam login(MagicalUser user){
		MagicalUserDao dao = new MagicalUserDao();
		MagicalUser mUser = null;

		dao.open();
		mUser = dao.getMagicalUserByLogin(user.getUsername(), user.getPassword());
		dao.close();
				
		if(mUser != null){
			PrivateInfoDao pd = new PrivateInfoDao();
			UserParam up = new UserParam();
			
//			pd.open();
			up.setPrivateUserInfo(pd.getPrivateInfoByUser(mUser));
//			pd.close();
			up.setUser(mUser);
//			up.setToken(TokenService.createTokenForUser(mUser).getToken());
			return up;
		}
		
		return null;
	}
}

