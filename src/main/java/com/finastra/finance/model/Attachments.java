package com.finastra.finance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity (name="attachments")
@Table(name = "tbl_file_attachments")
public class Attachments 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "file_id")
	private int file_id;
	
	@Column(name = "forex_id")
	private int forex_id;
	
	@Column(name = "file_name")
	private String file_name;
	
	@Column(name = "file_type")
	private String file_type;
	
	@Lob
	@Column(name = "file_content")
	private byte[] file_content;

	
	public Attachments() {
		super();
	}

	public Attachments(int file_id, int forex_id, String file_name, String file_type, byte[] file_content) {
		super();
		this.file_id = file_id;
		this.forex_id = forex_id;
		this.file_name = file_name;
		this.file_type = file_type;
		this.file_content = file_content;
	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public int getForex_id() {
		return forex_id;
	}

	public void setForex_id(int forex_id) {
		this.forex_id = forex_id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_type() {
		return file_type;
	}

	public void setFile_type(String file_type) {
		this.file_type = file_type;
	}

	public byte[] getFile_content() {
		return file_content;
	}

	public void setFile_content(byte[] file_content) {
		this.file_content = file_content;
	}
	
	
}
