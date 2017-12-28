package com.revature.merlinserver.rest;

import java.util.List;

import javax.ws.rs.Path;

import com.revature.merlinserver.beans.IMThread;
import com.revature.merlinserver.dao.IMThreadDao;

/**
 * Handles all Instant Messaging Thread requests
 * @author Antony Lulciuc
 */
@Path("/threads")
public class IMThreadForm {
	
	/**
	 * Acquires all threads m
	 * @return
	 */
	@Path("get/all")
	public List<IMThread> getAllThreads() {
		IMThreadDao dao = new IMThreadDao();
		List<IMThread> threads;
		
		// Get Threads
		dao.open();
		threads = dao.loadAll();
		dao.close();
		
		return threads;
	}
}
