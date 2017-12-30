package com.revature.merlinserver.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.beans.CodeList;
import com.revature.merlinserver.dao.CodeListDao;

@Path("/codelist")
public class CodeListRest {

	/**
	 * Grabs all state codelists.
	 * @return the list of state codelists
	 */
	@GET
	@Path("/getcodelist/{code}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CodeList> getStateCodeLists(@PathParam("code") String code) {
		List<CodeList> codelist = null;
		CodeListDao codeListDao = new CodeListDao();

		codeListDao.open();
		codelist = codeListDao.getCodeListsByCode(code); //grab all code lists by given code
		codeListDao.close();

		return codelist;
	}
	
	/**
	 * Get the stateCity codelist from a state value and city value
	 * @param stateId
	 * @param cityId
	 * @return the codelist
	 */
	@GET
	@Path("/getstatecitycode/{state}/{city}")
	@Produces(MediaType.APPLICATION_JSON)
	public CodeList getStateCityCodeList(@PathParam("state") String stateId,
			@PathParam("city") String cityId) {
		CodeList stateCity = null;
		CodeListDao codeListDao = new CodeListDao();
		
		codeListDao.open();
		stateCity = codeListDao.getStateCity(stateId, cityId);
		codeListDao.close();

		return stateCity;
	}
}