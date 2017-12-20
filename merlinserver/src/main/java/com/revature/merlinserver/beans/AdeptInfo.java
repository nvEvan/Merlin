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

/**
 * Bean holding information regarding adept payment preferences.
 * @author Alex
 */
@Entity
@Table(name="AdeptInfo")
public class AdeptInfo implements BusinessObject {
	/**
	 * Added required field member
	 */
	@Id
	@SequenceGenerator(sequenceName="ADEPT_INFO_SEQ", name="ADEPT_INFO_SEQ")
	@GeneratedValue(generator="ADEPT_INFO_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="ADEPT_ID")
	private MagicalUser adept;

	@OneToOne
	@JoinColumn(name="PAYMENT_INFO")
	private CodeList paymentInfo;

	@Column(precision=2, scale=8)
	private Double price;

	/**
	 * No-args constructor
	 */
	public AdeptInfo() {
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param adept
	 * @param paymentInfo
	 * @param price
	 */
	public AdeptInfo(Integer id, MagicalUser adept, CodeList paymentInfo, Double price) {
		super();
		this.id = id;
		this.adept = adept;
		this.paymentInfo = paymentInfo;
		this.price = price;
	}
	
	/**
	 * Constructor
	 * @param adept
	 * @param paymentInfo
	 * @param price
	 */
	public AdeptInfo(MagicalUser adept, CodeList paymentInfo, Double price) {
		super();
		this.adept = adept;
		this.paymentInfo = paymentInfo;
		this.price = price;
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

	public CodeList getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(CodeList paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}