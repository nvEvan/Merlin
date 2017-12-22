package merlin.revature.rest;

import java.util.ArrayList;

import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import merlin.revature.beans.UserPrivateInfo;
import merlin.revature.beans.UserPublicInfo;

@Path("/user")
public class UserRest {
	
	public static List<UserPublicInfo> upub = new ArrayList<UserPublicInfo>();
	public static List<UserPrivateInfo> upri = new ArrayList<>();
	
	@GET
	@Path("/get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserPublicInfo> getUsers(){
		
		upub.add(new UserPublicInfo(1, "Merlin", "Merlin", "Merlinson"));
		upub.add(new UserPublicInfo(2, "GreyBeard", "Gandalf", "Grey"));
		upub.add(new UserPublicInfo(3, "Alby", "Albus", "Dumbledoor"));
		
		
		return upub;
	}
	
	@GET
	@Path("get/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserPublicInfo getUser(@PathParam("username") String username){
		for(UserPublicInfo u : upub){
			if(username.equals(u.getUsername()))
				return u;
		}
		return null;
	}
	
	@GET
	@Path("/get/private/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UserPrivateInfo> getPrivate(){
		
		upri.add(new UserPrivateInfo(1, "Merlin", "Merlin", "271839", "the Woods", "Camelot", "Somewhere", "merly@someplace"));
		upri.add(new UserPrivateInfo(2, "GreyBeard", "wizard", "271839", "the Woods", "LOR", "Somewhere", "tolkien@someplace"));
		upri.add(new UserPrivateInfo(3, "Alby", "potter", "271839", "Hogwarts", "Chimney", "Not Here", "harry@someplace"));
		
		return upri;
	}
	
	@GET
	@Path("get/private/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public UserPrivateInfo getPrivate(@PathParam("username") String username){
		
		for(UserPrivateInfo u : upri){
			if(username.equals(u.getUsername()))
				return u;
		}
		
		return null;
	}
	
	
}
