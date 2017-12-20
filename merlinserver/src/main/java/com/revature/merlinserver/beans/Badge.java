package com.revature.merlinserver.beans;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Bean used to hold information about badges.
 * Badges being rewards for adepts and apprentices.
 * @author Alex
 */
@Entity
@Table(name="Badge")
public class Badge implements BusinessObject {
	@Id
	@Column(name = "badge_id")
	@SequenceGenerator(sequenceName = "BADGE_SEQ", name = "BADGE_SEQ")
	@GeneratedValue(generator = "BADGE_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer badgeId;
	
	@Column(nullable = false)
	private Blob image;
	
	@Column(name="MIN_SCORE", nullable = false)
	private int minScore;
	
	@Column(nullable = false)
	private String description;
	
	/**
	 * No-args constructor
	 */
	public Badge(){
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param image
	 * @param minScore
	 * @param description
	 */
	public Badge(Blob image, int minScore, String description) {
		super();
		this.image = image;
		this.minScore = minScore;
		this.description = description;
	}

	/**
	 * Constructor used when pulling a badge from the DB.
	 * @param badgeId
	 * @param image
	 * @param minScore
	 * @param description
	 */
	public Badge(Integer badgeId, Blob image, int minScore, String description) {
		super();
		this.badgeId = badgeId;
		this.image = image;
		this.minScore = minScore;
		this.description = description;
	}

	public Integer getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(Integer badgeId) {
		this.badgeId = badgeId;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public int getMinScore() {
		return minScore;
	}

	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}