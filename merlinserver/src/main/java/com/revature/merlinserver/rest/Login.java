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
	public PrivateUserInfo getPrivateUserInfo(MagicalUser user){
		MagicalUserDao dao = new MagicalUserDao();
		MagicalUser mUser = null;
		PrivateUserInfo info = null;

		dao.open();
		mUser = dao.getMagicalUserByLogin(user.getUsername(), user.getPassword());
		dao.close();
				
		if(mUser != null){
			TokenDao td = new TokenDao();
			Token token = null;
			PrivateInfoDao pd = new PrivateInfoDao();
			
			td.open();
			token = td.getTokenByUser(mUser);
			td.close();
			
			pd.open();
			info = pd.getPrivateInfoByUser(mUser);
			pd.close();
			
			return info;
		} else{
			return null;
		}
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

