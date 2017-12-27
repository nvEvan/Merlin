package com.revature.merlinserver.rest;

import java.util.List;

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

/**
 * TODO : do login validation and other stuff
 * @author Luie
 */
@Path("/login")
public class Login {
	
	// TODO : do login stuff
	@POST
	@Path("/validate")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String validate(MagicalUser user) {
		return "stuff = " + user.getUsername() + " " + user.getPassword();
	}
	
	//Gets all users 
	@POST
	@Path("/MagicalUser")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MagicalUser> getMagicalUsers(){
		MagicalUserDao dao = new MagicalUserDao();
		dao.open();
		List<MagicalUser> users = dao.loadAll();
		dao.close();
		return users;
	}
	
	//Get explicit user
	@POST
	@Path("/MagicalUser/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public MagicalUser getMagicalUser(@PathParam("username") String username){
		MagicalUserDao dao = new MagicalUserDao();
		dao.open();
		List<MagicalUser> users = dao.loadAll();
		dao.close();
		for(MagicalUser m : users){
			if(username.equals(m.getUsername())){
				return m;
			}
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

