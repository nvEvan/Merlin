package com.revature.merlinserver.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.dao.CodeListDao;

@Path("/codelist")
public class CodeList {
	
	/**
	 * Grabs all state codelists.
	 * @return the list of state codelists
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/state")
	public List<com.revature.merlinserver.beans.CodeList> getStateCodeLists() {
		List<com.revature.merlinserver.beans.CodeList> states = null;
		CodeListDao codeListDao = new CodeListDao();
		
		codeListDao.open();
		states = codeListDao.getCodeListsByCode("US-STATE"); //grab all state code lists
		codeListDao.close();
		
		return states;
	}
	
	/**
	 * Grabs all city codelists.
	 * @return
	 */
	@GET
	@Path("/city")
	@Produces(MediaType.APPLICATION_JSON)
	public List<com.revature.merlinserver.beans.CodeList> getCityCodeLists() {
		List<com.revature.merlinserver.beans.CodeList> cities = null;
		CodeListDao codeListDao = new CodeListDao();
		
		codeListDao.open();
		cities = codeListDao.getCodeListsByCode("US-CITY"); //grab all state code lists
		codeListDao.close();
		
		return cities;
	}
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		
		return "hello";
	}
}