package com.revature.merlinserver.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Luie
 */
@Entity
@Table(name="MagicalUser")
public class MagicalUser {
	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(sequenceName="USER_SEQ", name="USER_SEQ")
	@GeneratedValue(generator="USER_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer userId;
	
	@Column(unique = true, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	/**
	 * No - Args Constructor
	 */
	public MagicalUser() {
		super();
	}
	
	/**
	 * Constructor
	 * @param username - name for user (must be unique)
	 * @param password - used to ensure user is user
	 */
	public MagicalUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	/**
	 * Constructor
	 * @param userId - unique identifier fir user record
	 * @param username - name for user (must be unique)
	 * @param password - used to ensure user is user
	 */
	public MagicalUser(Integer userId, String username, String password) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
