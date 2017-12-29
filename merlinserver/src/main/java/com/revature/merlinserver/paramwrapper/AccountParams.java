package com.revature.merlinserver.paramwrapper;

import com.revature.merlinserver.beans.MagicalUser;
import com.revature.merlinserver.beans.PrivateUserInfo;
import com.revature.merlinserver.beans.PublicUserInfo;

public class AccountParams extends TokenParam {
	MagicalUser general;
	PrivateUserInfo privateInfo;
	PublicUserInfo publicInfo;
	
	public AccountParams() {
		
	}
	
	
	public AccountParams(String token) {
		super(token);
		// TODO Auto-generated constructor stub
	}

	public AccountParams(MagicalUser general, PrivateUserInfo privateInfo, PublicUserInfo publicInfo) {
		super();
		this.general = general;
		this.privateInfo = privateInfo;
		this.publicInfo = publicInfo;
	}
	
	public MagicalUser getGeneral() {
		return general;
	}
	public void setGeneral(MagicalUser general) {
		this.general = general;
	}
	public PrivateUserInfo getPrivateInfo() {
		return privateInfo;
	}
	public void setPrivateInfo(PrivateUserInfo privateInfo) {
		this.privateInfo = privateInfo;
	}
	public PublicUserInfo getPublicInfo() {
		return publicInfo;
	}
	public void setPublicInfo(PublicUserInfo publicInfo) {
		this.publicInfo = publicInfo;
	}
}
