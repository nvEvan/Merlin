package com.revature.merlinserver.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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
	@Path("/getcodelist/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<com.revature.merlinserver.beans.CodeList> getStateCodeLists(@PathParam("code") String code) {
		List<com.revature.merlinserver.beans.CodeList> codelist = null;
		CodeListDao codeListDao = new CodeListDao();
		
		codeListDao.open();
		codelist = codeListDao.getCodeListsByCode(code); //grab all code lists by given code
		codeListDao.close();
		
		return codelist;
	}
}