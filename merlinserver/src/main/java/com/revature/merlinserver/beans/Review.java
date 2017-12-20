package com.revature.merlinserver.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Check;

/**
 * Bean holding information regarding apprentice to adept reviews.
 * @author Alex
 */
@Entity
@Table(name="Review")
@Check(constraints="score < 6 <> score > 0")
public class Review implements BusinessObject {
	/**
	 * Added required field member
	 */
	@Id
	@SequenceGenerator(sequenceName="REVIEW_SEQ", name="REVIEW_SEQ")
	@GeneratedValue(generator="REVIEW_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="APPRENTICE_COLUMN")
	private MagicalUser apprentice;
	
	@OneToOne
	@JoinColumn(name="ADEPT_COLUMN")
	private MagicalUser adept;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false, columnDefinition = "a")
	private Double score;

	/**
	 * No-args constructor
	 */
	public Review() {
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param apprentice
	 * @param adept
	 * @param description
	 * @param score
	 */
	public Review(Integer id, MagicalUser apprentice, MagicalUser adept, String description, Double score) {
		super();
		this.id = id;
		this.apprentice = apprentice;
		this.adept = adept;
		this.description = description;
		this.score = score;
	}

	/**
	 * Constructor
	 * @param apprentice
	 * @param adept
	 * @param description
	 * @param score
	 */
	public Review(MagicalUser apprentice, MagicalUser adept, String description, Double score) {
		super();
		this.apprentice = apprentice;
		this.adept = adept;
		this.description = description;
		this.score = score;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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