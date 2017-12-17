package com.revature.merlinserver.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Stores private account information not viewable by other users 
 * @author Luie
 */
@Entity
@Table(name = "PrivateUserInfo")
public class PrivateUserInfo {
	private Integer privateUserId;
	private Integer userId;
	private Integer roleId;
	private Integer stateCityId;
	private Integer statusId;
	private String firstName;
	private String lastname;
	private String email;
	private String phoneNumber;
	private String address;
	
	/**
	 * No-args constructor
	 */
	public PrivateUserInfo() {
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param userId - MagicalUser id
	 * @param roleId - What are they (wizard/adept/apprentice)
	 * @param stateCityId - What state/city they from
	 * @param statusId - what is their account status (active/paused/banned)
	 * @param firstName
	 * @param lastname
	 * @param email
	 * @param phoneNumber
	 * @param address
	 */
	public PrivateUserInfo(Integer userId, Integer roleId, Integer stateCityId, Integer statusId,
			String firstName, String lastname, String email, String phoneNumber, String address) {
		super();
		this.privateUserId = privateUserId;
		this.userId = userId;
		this.roleId = roleId;
		this.stateCityId = stateCityId;
		this.statusId = statusId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	/**
	 * Constructor
	 * @param privateUserId
	 * @param userId - MagicalUser id
	 * @param roleId - What are they (wizard/adept/apprentice)
	 * @param stateCityId - What state/city they from
	 * @param statusId - what is their account status (active/paused/banned)
	 * @param firstName
	 * @param lastname
	 * @param email
	 * @param phoneNumber
	 * @param address
	 */
	public PrivateUserInfo(Integer privateUserId, Integer userId, Integer roleId, Integer stateCityId, Integer statusId,
			String firstName, String lastname, String email, String phoneNumber, String address) {
		super();
		this.privateUserId = privateUserId;
		this.userId = userId;
		this.roleId = roleId;
		this.stateCityId = stateCityId;
		this.statusId = statusId;
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}

	public Integer getPrivateUserId() {
		return privateUserId;
	}

	public void setPrivateUserId(Integer privateUserId) {
		this.privateUserId = privateUserId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getStateCityId() {
		return stateCityId;
	}

	public void setStateCityId(Integer stateCityId) {
		this.stateCityId = stateCityId;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
