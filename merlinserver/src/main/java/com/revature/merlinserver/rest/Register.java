package com.revature.merlinserver.rest;

import java.util.concurrent.ExecutionException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.beans.Token;
import com.revature.merlinserver.dao.MagicalUserDao;
import com.revature.merlinserver.dao.TokenDao;
import com.revature.merlinserver.service.TokenService;
import com.revature.merlinserver.service.UserVerificationService;

/**
 * 
 * @author Alex
 *
 */
@Path("/register")
public class Register {

	/**
	 * Rest call from angular to register a new user.
	 * @param token
	 */
	@POST
	@Path("/create") //this the path we want to use?
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public void register(MagicalUser user, PrivateUserInfo userinfo) {


		//register user




		/*-----------Send email to user-------------*/
		Token token = TokenService.createToken(user);
		TokenDao td = new TokenDao();
		td.open();
		td.insertToken(token);
		td.close();

		try {
			UserVerificationService.sendVerification(userinfo.getEmail(), token.getToken());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * When a user clicks on their email verification link.
	 * @param token
	 */
	@GET
	@Path("/authenticate{token}")
	@Produces(MediaType.TEXT_PLAIN)
	public void authenticate(@PathParam("token") String token) {

		MagicalUserDao md = new MagicalUserDao();
		TokenDao td = new TokenDao();

		if (td.tokenExistsAndIsNew(token)) {
				
			
			//set user's status to active



		} else {
			//the user did not click the link in their email
			//they are entering a phony token
		}



	}
}
