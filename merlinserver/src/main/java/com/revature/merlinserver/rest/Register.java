package com.revature.merlinserver.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/register")
public class Register {

	@POST
	@Path("/authenticate{token}")
	@Produces(MediaType.TEXT_PLAIN)
	public void validate(@PathParam("token") String token) {
		
		
		
	}
}
