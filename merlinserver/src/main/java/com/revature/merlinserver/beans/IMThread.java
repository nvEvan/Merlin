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
 * Defines thread properties used to link to Firebase database Instant Messaging data
 * @author Luie
 */
@Entity
@Table(name="IMThread")
public class IMThread implements BusinessObject {
	@Id
	@SequenceGenerator(sequenceName="IMTHREAD_SEQ", name="IMTHREAD_SEQ")
	@GeneratedValue(generator="IMTHREAD_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="CREATOR_ID")
	private MagicalUser creator;
	
	@OneToOne
	@JoinColumn(name="STATUS_ID")
	private CodeList status;
	
	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	private String link;
	
	@Column(nullable=false)
	private Date threadCreationDate;

	/**
	 * No-args constructor
	 */
	public IMThread() {
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param creator - who created the thread 
	 * @param status - what is the thread status? 
	 * @param name - name/title of the thread 
	 * @param link - how to link data to thread 
	 * @param threadCreationDate - when was this thread created 
	 */
	public IMThread(MagicalUser creator, CodeList status, String name, String link, Date threadCreationDate) {
		super();
		this.creator = creator;
		this.status = status;
		this.name = name;
		this.link = link;
		this.threadCreationDate = threadCreationDate;
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param creator - who created the thread 
	 * @param status - what is the thread status? 
	 * @param name - name/title of the thread 
	 * @param link - how to link data to thread 
	 * @param threadCreationDate - when was this thread created 
	 */
	public IMThread(Integer id, MagicalUser creator, CodeList status, String name, String link, Date threadCreationDate) {
		super();
		this.id = id;
		this.creator = creator;
		this.status = status;
		this.name = name;
		this.link = link;
		this.threadCreationDate = threadCreationDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MagicalUser getCreator() {
		return creator;
	}

	public void setCreator(MagicalUser creator) {
		this.creator = creator;
	}

	public CodeList getStatus() {
		return status;
	}

	public void setStatus(CodeList status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getThreadCreationDate() {
		return threadCreationDate;
	}

	public void setThreadCreationDate(Date threadCreationDate) {
		this.threadCreationDate = threadCreationDate;
	}

	@Override
	public String toString() {
		return "IMThread [id=" + id + ", creator=" + creator + ", status=" + status + ", name=" + name + ", link="
				+ link + ", threadCreationDate=" + threadCreationDate + "]";
	}
}
