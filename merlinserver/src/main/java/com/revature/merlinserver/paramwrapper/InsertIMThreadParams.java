package com.revature.merlinserver.paramwrapper;

import com.revature.merlinserver.beans.IMThread;

/**
 * Handles Requests for inserting IMThreads
 * @author Antony Lulciuc
 */
public class InsertIMThreadParams extends TokenParam {
	private IMThread thread;

	public InsertIMThreadParams() {
		super();
	}
	
	public IMThread getThread() {
		return thread;
	}

	public void setThread(IMThread thread) {
		this.thread = thread;
	}
}
