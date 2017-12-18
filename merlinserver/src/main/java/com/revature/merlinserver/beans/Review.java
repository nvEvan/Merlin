package com.revature.merlinserver.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

/**
 * Bean holding information regarding apprentice to adept reviews.
 * @author Alex
 */
@Entity
@Table(name="Review")
@Check(constraints="score < 6 <> score > 0")
public class Review {
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private MagicalUser apprentice;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private MagicalUser adept;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false, columnDefinition = "a")
	private Double score;

	public Review(MagicalUser apprentice, MagicalUser adept, String description, Double score) {
		super();
		this.apprentice = apprentice;
		this.adept = adept;
		this.description = description;
		this.score = score;
	}

	public MagicalUser getApprentice() {
		return apprentice;
	}

	public void setApprentice(MagicalUser apprentice) {
		this.apprentice = apprentice;
	}

	public MagicalUser getAdept() {
		return adept;
	}

	public void setAdept(MagicalUser adept) {
		this.adept = adept;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}
}