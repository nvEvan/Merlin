package com.revature.merlinserver.paramwrapper;

import com.revature.merlinserver.beans.PublicUserInfo;

public class UserParam extends RegisterParams {
	private PublicUserInfo publicUserInfo;

	public PublicUserInfo getPublicInfo() {
		return publicUserInfo;
	}

	public void setPublicInfo(PublicUserInfo publicInfo) {
		this.publicUserInfo = publicInfo;
	}
}
