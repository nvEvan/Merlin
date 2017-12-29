package com.revature.merlinserver.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.revature.merlinserver.beans.IMThread;
import com.revature.merlinserver.dao.IMThreadDao;

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
		
		return threads;
	}
	
	@POST
	@Path("insert")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertIMThread(IMThread thread) {
		IMThreadDao dao = new IMThreadDao();
		String response;
		
		// open connection
		dao.open();
		
		// insert data
		response = dao.insertIMThread(thread) == 1 ? "ok" : "Failed to insert IMThread, where IMThread=[" + thread + "]";
		
		// close connection
		dao.close();
		
		return response;
	}
	
}
