package com.finastra.finance.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "tbl_employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int emp_id;
	
	@NotEmpty(message = "*Please provide the Employee Number")
	@Column(name="emp_no")
	private String emp_no;
	
	@Column(name="active")
	private String active;
	
	@NotEmpty(message = "*Please provide the Name")
	@Column(name="emp_nm")
	private String emp_nm;
	
	@Column(name="email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="manager_id")
	private int manager_id;
	
	@Column(name="project_code")
	private String project_code;
	
	@Column(name="project_name")
	private String project_name;
	
	@Column(name="dob")
	private Date dob;
	
	@Column(name="passport_no")
	private String passport_no;
	
	@Column(name="passport_issue_date")
	private Date passport_issue_date;
	
	@Column(name="passport_expiry_date")
	private Date passport_expiry_date;
	
	@Column(name="tax_id")
	private String tax_id;
	
	@Column(name="uid")
	private String uid;
}
