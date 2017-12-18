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

import org.hibernate.annotations.Check;

/**
 * 
 * @author Luie
 */
@Entity
@Table(name="SessionAvailability")
@Check(constraints="start_datetime < end_datetime")
public class SessionAvailability {
	@Id
	@Column(name="session_availability_id")
	@SequenceGenerator(sequenceName="SESSION_AVA_SEQ", name="SESSION_AVA_SEQ")
	@GeneratedValue(generator="SESSION_AVA_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer sessionAvailabiltyId;
	
	@OneToOne
	@JoinColumn(name="ADEPT_ID")
	private MagicalUser adept;
	
	@Column(name="start_datetime", nullable=false)
	private Date startDateTime;
	
	@Column(name="end_datetime", nullable=false)
	private Date endDateTime;
	
	@Column(name="recurring_time")
	private Boolean recurringTime;
	
	/**
	 * No-args constructor
	 */
	public SessionAvailability() {
		// do nothing
	}

	/**
	 * Constructor
	 * @param sessionAvailabiltyId
	 * @param adept
	 * @param startDateTime
	 * @param endDateTime
	 * @param recurringTime
	 */
	public SessionAvailability(MagicalUser adept, Date startDateTime, Date endDateTime,
			Boolean recurringTime) {
		super();
		this.adept = adept;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.recurringTime = recurringTime;
	}
	
	/**
	 * Constructor
	 * @param sessionAvailabiltyId
	 * @param adept
	 * @param startDateTime
	 * @param endDateTime
	 * @param recurringTime
	 */
	public SessionAvailability(Integer sessionAvailabiltyId, MagicalUser adept, Date startDateTime, Date endDateTime,
			Boolean recurringTime) {
		super();
		this.sessionAvailabiltyId = sessionAvailabiltyId;
		this.adept = adept;
		this.startDateTime = startDateTime;
		this.endDateTime = endDateTime;
		this.recurringTime = recurringTime;
	}

	public Integer getSessionAvailabiltyId() {
		return sessionAvailabiltyId;
	}

	public void setSessionAvailabiltyId(Integer sessionAvailabiltyId) {
		this.sessionAvailabiltyId = sessionAvailabiltyId;
	}

	public MagicalUser getAdept() {
		return adept;
	}

	public void setAdept(MagicalUser adept) {
		this.adept = adept;
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

	public Boolean getRecurringTime() {
		return recurringTime;
	}

	public void setRecurringTime(Boolean recurringTime) {
		this.recurringTime = recurringTime;
	}
}
