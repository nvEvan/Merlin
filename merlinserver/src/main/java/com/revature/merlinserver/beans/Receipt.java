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
 * Bean class to hold all receipts regarding tutoring sessions.
 * Will hold information regarding both parties of transaction and details of the transaction.
 * @author Alex
 */
@Entity
@Table(name="Receipt")
public class Receipt implements BusinessObject {
	
	@Id
	@Column(name="receipt_id")
	@SequenceGenerator(sequenceName="RECEIPT_SEQ", name="RECEIPT_SEQ")
	@GeneratedValue(generator="RECEIPT_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer receiptId;
	
	@OneToOne
	@JoinColumn(name="APPRENTICE_ID")
	private MagicalUser apprentice;
	
	@OneToOne
	@JoinColumn(name="ADEPT_ID")
	private MagicalUser adept;
	
	@Column(nullable = false)
	private Date timestamp;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Float amount;
	
	public Receipt() {
		
	}

	/**
	 * Use this constructor when pulling a receipt from the DB.
	 * @param receipt_id
	 * @param payment_from_id
	 * @param payment_to_id
	 * @param timestamp
	 * @param description
	 * @param amount
	 */
	public Receipt(Integer receiptId, MagicalUser apprentice, MagicalUser adept, Date timestamp, String description,
			Float amount) {
		super();
		this.receiptId = receiptId;
		this.apprentice = apprentice;
		this.adept = adept;
		this.timestamp = timestamp;
		this.description = description;
		this.amount = amount;
	}

	/**
	 * Use this constructor when inserting into the DB.
	 * @param payment_from_id
	 * @param payment_to_id
	 * @param timestamp
	 * @param description
	 * @param amount
	 */
	public Receipt(MagicalUser apprentice, MagicalUser adept, Date timestamp, String description, Float amount) {
		super();
		this.apprentice = apprentice;
		this.adept = adept;
		this.timestamp = timestamp;
		this.description = description;
		this.amount = amount;
	}

	public Integer getReceiptId() {
		return receiptId;
	}

	public void receiptId(Integer receiptId) {
		this.receiptId = receiptId;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getAmount() {
		return amount;
	}

	public void setAmount(Float amount) {
		this.amount = amount;
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
}