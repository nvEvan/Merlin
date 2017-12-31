package com.revature.merlinserver.paramwrapper;

import com.revature.merlinserver.beans.PublicUserInfo;

/**
 * Contains data for the FetchAdepts web service
 * @author Evan
 *
 */
public class FetchAdeptsParams {
	private PublicUserInfo info; 
	private double avg_review;
	
	/**
	 * Getter for info member variable
	 * @return info - a PublicUserInfo object
	 */
	public PublicUserInfo getInfo() {
		return info;
	}
	
	/**
	 * Setter for info member variable
	 * @param info - The Object to be stored. A PublicUserInfo object. 
	 */
	public void setInfo(PublicUserInfo info) {
		this.info = info;
	}
	
	/**
	 * Getter for avg_review
	 * @return double containing the average review
	 */
	public double getAvg_review() {
		return avg_review;
	}
	
	/**
	 * setter for avg_review
	 * @param avg_review - double to be stored
	 */
	public void setAvg_review(double avg_review) {
		this.avg_review = avg_review;
	}
	
	/**
	 * Constructor 
	 * @param info - PublicUserInfo object
	 * @param avg_review - double
	 */
	public FetchAdeptsParams(PublicUserInfo info, double avg_review) {
		super();
		this.info = info;
		this.avg_review = avg_review;
	}
}
