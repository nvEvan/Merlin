package com.revature.merlinserver.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Stores private account information not viewable by other users 
 * @author Luie
 */
@Entity
@Table(name = "PrivateUserInfo")
public class PrivateUserInfo implements BusinessObject {
	
	@Id
	@Column(name = "privateuserinfo_id")
	@SequenceGenerator(sequenceName = "PRVT_USER_INFO_SEQ", name = "PRVT_USER_INFO_SEQ")
	@GeneratedValue(generator = "PRVT_USER_INFO_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer privateUserId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MAGICAL_USER")
	private MagicalUser user;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ROLE_COLUMN")
	private CodeList role;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STATE_CITY_COLUMN")
	private CodeList stateCity;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="STATUS_COLUMN")
	private CodeList status;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastname;
	
	@Column(nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String phoneNumber;
	
	@Column(nullable=false)
	private String address;
	
	/**
	 * No-args constructor
	 */
	public PrivateUserInfo() {
		// do nothing
	}

	public PrivateUserInfo(MagicalUser user, CodeList role, CodeList stateCity, CodeList status,
			String firstName, String lastname, String email, String phoneNumber, String address) {
		super();
		this.user = user;
		this.role = role;
		this.stateCity = stateCity;
		this.status = status;
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
	}
	
	public PrivateUserInfo(Integer privateUserId, MagicalUser user, CodeList role, CodeList stateCity, CodeList status,
			String firstName, String lastname, String email, String phoneNumber, String address) {
		super();
		this.privateUserId = privateUserId;
		this.user = user;
		this.role = role;
		this.stateCity = stateCity;
		this.status = status;
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

	public MagicalUser getUser() {
		return user;
	}

	public void setUser(MagicalUser user) {
		this.user = user;
	}

	public CodeList getRole() {
		return role;
	}

	public void setRole(CodeList role) {
		this.role = role;
	}

	public CodeList getStateCity() {
		return stateCity;
	}

	public void setStateCity(CodeList stateCity) {
		this.stateCity = stateCity;
	}

	public CodeList getStatus() {
		return status;
	}

	public void setStatus(CodeList status) {
		this.status = status;
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
