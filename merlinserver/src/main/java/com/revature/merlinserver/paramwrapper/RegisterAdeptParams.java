package com.revature.merlinserver.paramwrapper;

import com.revature.merlinserver.beans.MagicalFileUpload;
import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;

/**
 * Wrapper for user registration request arguments
 * @author Antony Lulciuc
 */
public class RegisterAdeptParams extends TokenParam {
	private MagicalUser user;
	private PrivateUserInfo privateUserInfo;
	private MagicalFileUpload magicalFileUpload;
	
	/**
	 * No-args Constructor
	 */
	public RegisterAdeptParams() {
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param user
	 * @param privateUserInfo
	 */
	public RegisterAdeptParams(MagicalUser user, PrivateUserInfo privateUserInfo, MagicalFileUpload magicalFileUpload) {
		super();
		this.user = user;
		this.privateUserInfo = privateUserInfo;
		this.magicalFileUpload = magicalFileUpload;
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

	public MagicalFileUpload getMagicalFileUpload() {
		return magicalFileUpload;
	}

	public void setMagicalFileUpload(MagicalFileUpload magicalFileUpload) {
		this.magicalFileUpload = magicalFileUpload;
	}
}