package com.revature.merlinserver.beans;

import java.sql.Blob;

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

/**
 * Bean holding all data relating to a user's public information
 * @author Alex
 */
@Entity
@Table(name = "PublicUserInfo")
public class PublicUserInfo implements BusinessObject {
	@Id
	@SequenceGenerator(sequenceName = "PUBLIC_USER_INFO_SEQ", name = "PUBLIC_USER_INFO_SEQ")
	@GeneratedValue(generator = "PUBLIC_USER_INFO_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer publicUserId;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MAGICAL_USER")
	private MagicalUser user;
	
	@OneToOne
	@JoinColumn(name="ROLE_COLUMN")
	private CodeList role;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	private String address;
	
	private String description;
	
	private Blob image;
	
	/**
	 * No-args constructor
	 */
	public PublicUserInfo() {
		// do nothing
	}
	
	/**
	 * Constructor used when submitting public user info
	 * @param user
	 * @param role
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param address
	 * @param description
	 * @param image
	 */
	public PublicUserInfo(MagicalUser user, CodeList role, String firstName, String lastName, String email,
			String phoneNumber, String address, String description, Blob image) {
		super();
		this.user = user;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.description = description;
		this.image = image;
	}

	/**
	 * Constructor used when pulling user's public info from the DB
	 * @param publicUserId
	 * @param user
	 * @param role
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param phoneNumber
	 * @param address
	 * @param description
	 * @param image
	 */
	public PublicUserInfo(Integer publicUserId, MagicalUser user, CodeList role, String firstName, String lastName,
			String email, String phoneNumber, String address, String description, Blob image) {
		super();
		this.publicUserId = publicUserId;
		this.user = user;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.description = description;
		this.image = image;
	}

	public Integer getPublicUserId() {
		return publicUserId;
	}

	public void setPublicUserId(Integer publicUserId) {
		this.publicUserId = publicUserId;
	}

	public MagicalUser getUser() {
		return user;
	}

	public void setUser(MagicalUser user) {
		this.user = user;
	}

	public CodeList getRole() {
		return role;
	}

	public void setRole(CodeList role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
}