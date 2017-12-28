package com.revature.merlinserver.paramwrapper;

/**
 * Base class for ALL classes used to receive/handle POST requests from client
 * @author Antony Lulciuc
 */
public class TokenParam {
	private String token;
	
	/**
	 * No-args Constructor
	 */
	public TokenParam() {
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param token - valid ID used to identify user
	 */
	public TokenParam(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
