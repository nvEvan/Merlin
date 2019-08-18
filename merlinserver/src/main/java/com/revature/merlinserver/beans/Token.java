package com.revature.merlinserver.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Alex
 *
 */
@Entity
@Table(name="Token")
public class Token {
	/**
	 * Added required field member
	 */
	@Id
	@SequenceGenerator(sequenceName="TOKEN_SEQ", name="TOKEN_SEQ")
	@GeneratedValue(generator="TOKEN_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
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