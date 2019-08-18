package com.revature.merlinserver.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="UserBadge")
public class UserBadge implements BusinessObject {
	/**
	 * Added required field member
	 */
	@Id
	@SequenceGenerator(sequenceName="USER_BADGE_SEQ", name="USER_BADGE_SEQ")
	@GeneratedValue(generator="USER_BADGE_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="USER_COLUMN")
	private MagicalUser user;
	
	@OneToOne
	@JoinColumn(name="BADGE_COLUMN")
	private Badge badge;
	
	/**
	 * No-args constructor
	 */
	public UserBadge() {
		// do nothing
	}

	public UserBadge(MagicalUser user, Badge badge) {
		super();
		this.user = user;
		this.badge = badge;
	}
	
	public UserBadge(Integer id, MagicalUser user, Badge badge) {
		super();
		this.id = id;
		this.user = user;
		this.badge = badge;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MagicalUser getUser() {
		return user;
	}

	public void setUser(MagicalUser user) {
		this.user = user;
	}

	public Badge getBadge() {
		return badge;
	}

	public void setBadge(Badge badge) {
		this.badge = badge;
	}
}
