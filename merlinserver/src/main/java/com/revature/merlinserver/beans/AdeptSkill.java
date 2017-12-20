package com.revature.merlinserver.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Bean class holding information regarding skills of an adept.
 * @author Alex
 */
@Entity
@Table(name="AdeptSkill")
public class AdeptSkill implements BusinessObject {
	/**
	 * Added required field member
	 */
	@Id
	@SequenceGenerator(sequenceName="ADEPT_SKILLS_SEQ", name="ADEPT_SKILLS_SEQ")
	@GeneratedValue(generator="ADEPT_SKILLS_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ADEPT_ID")
	private MagicalUser adept;
	
	@OneToOne
	@JoinColumn(name="SKILL_ID")
	private CodeList skill;
	
	/**
	 * No-args constructor
	 */
	public AdeptSkill() {
		// do nothing
	}

	/**
	 * Constructor
	 * @param adept
	 * @param skill
	 */
	public AdeptSkill(MagicalUser adept, CodeList skill) {
		super();
		this.adept = adept;
		this.skill = skill;
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param adept
	 * @param skill
	 */
	public AdeptSkill(Integer id, MagicalUser adept, CodeList skill) {
		super();
		this.id = id;
		this.adept = adept;
		this.skill = skill;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MagicalUser getAdept() {
		return adept;
	}

	public void setAdept(MagicalUser adept) {
		this.adept = adept;
	}

	public CodeList getSkill() {
		return skill;
	}

	public void setSkill(CodeList skill) {
		this.skill = skill;
	}
}