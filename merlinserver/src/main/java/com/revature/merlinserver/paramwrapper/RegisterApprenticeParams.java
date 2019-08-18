package com.revature.merlinserver.paramwrapper;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;

/**
 * Wrapper for user registration request arguments
 * @author Antony Lulciuc
 */
public class RegisterApprenticeParams extends TokenParam {
	private MagicalUser user;
	private PrivateUserInfo privateUserInfo;
	
	/**
	 * No-args Constructor
	 */
	public RegisterApprenticeParams() {
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param user
	 * @param privateUserInfo
	 */
	public RegisterApprenticeParams(MagicalUser user, PrivateUserInfo privateUserInfo) {
		super();
		this.user = user;
		this.privateUserInfo = privateUserInfo;
	}

	public MagicalUser getUser() {
		return user;
	}

	public void setUser(MagicalUser user) {
		this.user = user;
	}

	public PrivateUserInfo getPrivateUserInfo() {
		return privateUserInfo;
	}

	public void setPrivateUserInfo(PrivateUserInfo privateUserInfo) {
		this.privateUserInfo = privateUserInfo;
	}
}
