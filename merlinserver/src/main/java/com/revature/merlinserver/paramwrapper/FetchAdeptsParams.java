package com.revature.merlinserver.paramwrapper;

import com.revature.merlinserver.beans.PublicUserInfo;

public class FetchAdeptsParams {
	private PublicUserInfo info; 
	private double avg_review;
	public PublicUserInfo getInfo() {
		return info;
	}
	public void setInfo(PublicUserInfo info) {
		this.info = info;
	}
	public double getAvg_review() {
		return avg_review;
	}
	public void setAvg_review(double avg_review) {
		this.avg_review = avg_review;
	}
	public FetchAdeptsParams(PublicUserInfo info, double avg_review) {
		super();
		this.info = info;
		this.avg_review = avg_review;
	}
}
