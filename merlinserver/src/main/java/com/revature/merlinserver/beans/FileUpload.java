package com.revature.merlinserver.beans;

import java.sql.Blob;

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
 * Defines container for file upload/download
 * @author Luie
 */
@Entity
@Table(name="FileUpload")
public class FileUpload implements BusinessObject {
	@Id 
	@SequenceGenerator(sequenceName="FILEUPLOAD_SEQ", name="FILEUPLOAD_SEQ")
	@GeneratedValue(generator="FILEUPLOAD_SEQ", strategy=GenerationType.SEQUENCE)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name="USER_ID")
	private MagicalUser user;
	
	@OneToOne
	@JoinColumn(name="FILE_TYPE_ID")
	private CodeList fileType;
	
	@Column(name="file_name", nullable=false)
	private String fileName;
	
	@Column(nullable=false)
	private Blob file;

	/**
	 * No-args constructor
	 */
	public FileUpload() {
		// do nothing
	}
	
	/**
	 * Constructor
	 * @param user - who uploaded the file
	 * @param fileType - what type of file (CERTIFICATE/PROFILE-PIC/OTHER)
	 * @param fileName - name of the file
	 * @param file - the actual file
	 */
	public FileUpload(MagicalUser user, CodeList fileType, String fileName, Blob file) {
		super();
		this.user = user;
		this.fileType = fileType;
		this.fileName = fileName;
		this.file = file;
	}
	
	/**
	 * Constructor
	 * @param id
	 * @param user - who uploaded the file
	 * @param fileType - what type of file (CERTIFICATE/PROFILE-PIC/OTHER)
	 * @param fileName - name of the file
	 * @param file - the actual file
	 */
	public FileUpload(Integer id, MagicalUser user, CodeList fileType, String fileName, Blob file) {
		super();
		this.id = id;
		this.user = user;
		this.fileType = fileType;
		this.fileName = fileName;
		this.file = file;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MagicalUser getUser() {
		return user;
	}

	public void setUser(MagicalUser user) {
		this.user = user;
	}

	public CodeList getFileType() {
		return fileType;
	}

	public void setFileType(CodeList fileType) {
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Blob getFile() {
		return file;
	}

	public void setFile(Blob file) {
		this.file = file;
	}
}
