package com.revature.merlinserver.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Bean holding information regarding adept payment preferences.
 * @author Alex
 */
@Entity
@Table(name="ADEPT_INFO")
public class AdeptInfo {

	@OneToOne
	@Column(name="ADEPT_ID")
	private MagicalUser adept;

	@OneToOne
	@Column(name="PAYMENT_INFO")
	private CodeList paymentInfo;

	@Column(precision=2, scale=8)
	private Double price;

	public AdeptInfo() {

	}

	public AdeptInfo(MagicalUser adept, CodeList paymentInfo, Double price) {
		super();
		this.adept = adept;
		this.paymentInfo = paymentInfo;
		this.price = price;
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