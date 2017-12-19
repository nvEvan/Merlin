package com.revature.merlinserver.beans;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Bean class holding information regarding skills of an adept.
 * @author Alex
 */
@Entity
@Table(name="adept_skills")
public class AdeptSkills {
	
	@OneToOne(fetch=FetchType.EAGER)
	private MagicalUser adept;
	
	@OneToMany
	private CodeList skills;
	
	public AdeptSkills() {
		
	}

	public AdeptSkills(MagicalUser adept, CodeList skills) {
		super();
		this.adept = adept;
		this.skills = skills;
	}

	public MagicalUser getAdept() {
		return adept;
	}

	public void setAdept(MagicalUser adept) {
		this.adept = adept;
	}

	public CodeList getSkills() {
		return skills;
	}

	public void setSkills(CodeList skills) {
		this.skills = skills;
	}
}