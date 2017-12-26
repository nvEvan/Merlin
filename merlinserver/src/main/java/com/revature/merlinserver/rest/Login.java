package com.revature.merlinserver.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.dao.MagicalUserDao;

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
	@GET
	@Path("/MagicalUser")
	@Produces(MediaType.APPLICATION_JSON)
	public List<MagicalUser> getMagicalUsers(){
		MagicalUserDao dao = new MagicalUserDao();
		dao.open();
		List<MagicalUser> users = dao.loadAll();
		System.out.println(users);
		for(MagicalUser m : users){
			System.out.println(m.getUsername());
		}
		dao.close();
		return users;
	}
}

