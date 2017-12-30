package com.revature.merlinserver.rest;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.beans.IMThread;
import com.revature.merlinserver.dao.IMThreadDao;
import com.revature.merlinserver.paramwrapper.InsertIMThreadParams;
import com.revature.merlinserver.service.TokenService;
import com.revature.util.DateUtil;

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
	public List<IMThread> getAllThreads() {
		IMThreadDao dao = new IMThreadDao();
		List<IMThread> threads;
		
		// open connection
		dao.open();
		
		// Get Threads
		threads = dao.loadAll();
		
		// close connection
		dao.close();
		
		Date d = DateUtil.toDate("10/10/2017");
		
		return threads;
	}
	
	/**
	 * Insert new IMThread thread
	 * @param params - new thread
	 * @return 'ok' if successful
	 */
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertIMThread(InsertIMThreadParams params) {
		IMThreadDao dao = new IMThreadDao();
		String response = "invalid token";
		
		// if has valid token
		if (TokenService.isTokenValid(params.getToken())) {
			// open connection
			dao.open();
			
			// insert data
			response = dao.insertIMThread(params.getThread()) == 1 ? "ok" : "Failed to insert IMThread, where IMThread=[" + params.getThread() + "]";
			
			// close connection
			dao.close();
		}
		
		return response;
	}
	
}
