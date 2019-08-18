package com.revature.merlinserver.rest;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.revature.merlinserver.beans.IMThread;
import com.revature.merlinserver.dao.CodeListDao;
import com.revature.merlinserver.dao.IMThreadDao;
import com.revature.merlinserver.paramwrapper.InsertIMThreadParams;
import com.revature.merlinserver.service.TokenService;
import com.revature.util.ServiceUtil;

/**
 * Handles all Instant Messaging Thread requests
 * @author Antony Lulciuc
 */
@Path("/threads")
public class IMThreadForm {
	
	/**
	 * Acquires all threads 
	 * @return List of available threads
	 */
	@GET
	@Path("get/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllThreads() {
		IMThreadDao dao = new IMThreadDao();
		List<IMThread> threads;
		
		// open connection
		dao.open();
		
		// Get Threads
		threads = dao.loadAll();
		
		// close connection
		dao.close();
		
		return ServiceUtil.toJson(threads);
	}
	
	/**
	 * Insert new IMThread thread
	 * @param params - new thread
	 * @return 'ok' if successful
	 */
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertIMThread(InsertIMThreadParams params) {
		IMThreadDao dao = new IMThreadDao();
		CodeListDao cd = new CodeListDao();
		com.revature.merlinserver.beans.CodeList status = null;
		IMThread thread = null;
		
		// if has valid token
		if (TokenService.isTokenValid(params.getToken())) {
			// open connection
			dao.open();
			
			// If thread name is unique ONLY
			if (dao.findIMThreadByName(params.getThread().getName()) == null) {
				cd.setSession(dao.getSession());
				
				// get new status 
				status = cd.getCodeListsByCode("STATUS").stream().filter((item) -> item.getValue().equals("NEW")).collect(Collectors.toList()).get(0);
				thread = params.getThread();
				thread.setStatus(status);
				thread.setThreadCreationDate(new Date(new java.util.Date().getTime()));
				
				// insert data
				dao.insertIMThread(params.getThread());
			} 
			
			// close connection
			dao.close();
			
			// update token exp time
			TokenService.updateTokenByToken(params.getToken());
		}
		
		return thread == null ? null : ServiceUtil.toJson(params);
	}
	
}
