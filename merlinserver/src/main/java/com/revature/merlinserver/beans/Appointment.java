package com.revature.merlinserver.beans;

import java.sql.Date;

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

import org.hibernate.annotations.Check;

/**
 * Provides a way to keep track of adept and apprentice appointments 
 * @author Luie
 */
@Entity
@Table(name="Appointment")
@Check(constraints="start_datetime < end_datetime")
public class Appointment {
	@Id
	@SequenceGenerator(sequenceName="APPOINTMENT_SEQ", name="APPOINTMENT_SEQ")
	@GeneratedValue(generator="APPOINTMENT_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="ADEPT_ID")
	private MagicalUser adept;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="APPENTICE_ID")
	private MagicalUser apprentice;
	
	@OneToOne
	@JoinColumn(name="APPOINTMENT_STATE")
	private CodeList state;
	
	@Column(name="start_datetime", nullable=false)
	private Date startDateTime;
	
	@Column(name="end_datetime", nullable=false)
	private Date endDateTime;

	/**
	 * No-args constructor
	 */
	public Appointment() {
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param adept
	 * @param apprentice
	 * @param state
	 * @param startDateTime
	 * @param endDateTime
	 */
	public Appointment(MagicalUser adept, MagicalUser apprentice, CodeList state, Date startDateTime,
			Date endDateTime) {
		super();
		this.adept = adept;
		this.apprentice = apprentice;
		this.state = state;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
	}

	public MagicalUser getAdept() {
		return adept;
	}

	public void setAdept(MagicalUser adept) {
		this.adept = adept;
	}

	public MagicalUser getApprentice() {
		return apprentice;
	}

	public void setApprentice(MagicalUser apprentice) {
		this.apprentice = apprentice;
	}

	public CodeList getState() {
		return state;
	}

	public void setState(CodeList state) {
		this.state = state;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}
}
