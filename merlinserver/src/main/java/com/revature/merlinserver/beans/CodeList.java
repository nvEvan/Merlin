package com.revature.merlinserver.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Generic lookup table used throughout the system
 * @author Luie
 */
@Entity
@Table(name = "CodeList", 
	   uniqueConstraints =
			@UniqueConstraint(columnNames = {"code", "value", "description"}),
	   indexes = {
			   @Index(columnList = "code", name = "codelist_code_idx"),
			   @Index(columnList = "value", name = "codelist_value_idx"),
			   @Index(columnList = "description", name = "codelist_description_idx")
	   }
)
public class CodeList {
	
	@Id
	@Column(name="ID")
	@SequenceGenerator(sequenceName = "CODELIST_SEQ", name = "CODELIST_SEQ")
	@GeneratedValue(generator = "CODELIST_SEQ", strategy = GenerationType.SEQUENCE)
	private Integer id;
	
	@Column(nullable = false)
	private String code;
	
	@Column(nullable = false)
	private String value;
	
	@Column(nullable = false)
	private String description;

	/**
	 * No-args constructor
	 */
	public CodeList() {
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param code - used to group/categorize records
	 * @param value
	 * @param description
	 */
	public CodeList(String code, String value, String description) {
		super();
		this.code = code;
		this.value = value;
		this.description = description;
	}
	
	/**
	 * Constructor
	 * @param id - unique identifier 
	 * @param code - used to group/categorize records
	 * @param value
	 * @param description
	 */
	public CodeList(Integer id, String code, String value, String description) {
		super();
		this.id = id;
		this.code = code;
		this.value = value;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
