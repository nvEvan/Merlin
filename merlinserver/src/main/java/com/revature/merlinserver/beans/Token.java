package com.revature.merlinserver.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Token")
public class Token {
	
	@OneToOne
	@JoinColumn(name="user_id")
	private MagicalUser user;
	
	@Column(nullable = false)
	private String token;
	
	@Column(name="exp_date")
	private Date expDate;
	
	public Token() {
		
	}
	
	public Token(MagicalUser user, String token, Date expDate) {
		super();
		this.user = user;
		this.token = token;
		this.expDate = expDate;
	}

	public MagicalUser getUser() {
		return user;
	}

	public void setUser(MagicalUser user) {
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}
}