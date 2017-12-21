package com.revature.merlinserver.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.beans.MagicalUser;

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
}
