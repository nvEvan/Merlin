package com.revature.merlinserver.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.beans.Token;
import com.revature.merlinserver.dao.MagicalUserDao;
import com.revature.merlinserver.dao.PrivateInfoDao;
import com.revature.merlinserver.dao.TokenDao;
import com.revature.merlinserver.paramwrapper.RegisterParams;
import com.revature.merlinserver.paramwrapper.UserParam;
import com.revature.merlinserver.service.TokenService;

/**
 * TODO : do login validation and other stuff
 * @author Luie
 */
@Path("/login")
public class Login {
	
	//Get explicit user
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
			
			up.setPrivateUserInfo(pd.getPrivateInfoByUser(mUser));
			up.setUser(mUser);
			//up.setToken(TokenService.createTokenForUser(mUser).getToken());
			return up;
		}
		
		return null;
	}
	
	//Get explicit user info
	@POST
	@Path("/MagicalUser/info/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public PrivateUserInfo getPublicInfo(@PathParam("username") String username){
		PrivateInfoDao infoDao = new PrivateInfoDao();
		MagicalUserDao userDao = new MagicalUserDao();
		PrivateUserInfo info = null;
		
		userDao.open();
		List<MagicalUser> users = userDao.loadAll();
		userDao.close();
		
		for(MagicalUser m : users){
			if(username.equals(m.getUsername())){
				infoDao.open();
				info = infoDao.getPrivateInfoByUser(m);
				infoDao.close();
				return info;
			}
		}
		infoDao.close();
		return null;
	}
}

