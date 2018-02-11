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

@Entity (name = "employee")
@Table(name = "tbl_employee")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private int emp_id;
	
	@Column(name="emp_no")
	private String emp_no;
	
	@Column(name="active")
	private String active;
	
	@Column(name="emp_nm")
	private String emp_nm;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="manager_id")
	private String manager_id;
	
	@Column(name="manager_nm")
	private String manager_nm;
	
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
	
	@Column(name="emp_role")
	private String emp_role;
	
	private String sun_employee_id;
	
	private String old_id;
	
	private String id;
	
	private String er;
	
	private String old_er;
	
	private String cost_center;
	
	private String product;
	
	private String region;
	
	private String transaction_prefix;
	
	private String third_party;
	
	private String export_to_open_air;
	
	private String job_title;
	
	private String oa_department;
	
	private String expense_currency;
	
	private String login_access;
	
	private String job_level;
	
	private String cc;
	
	private Date termination_date;
	
	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getEmp_no() {
		return emp_no;
	}

	public void setEmp_no(String emp_no) {
		this.emp_no = emp_no;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getEmp_nm() {
		return emp_nm;
	}

	public void setEmp_nm(String emp_nm) {
		this.emp_nm = emp_nm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getProject_code() {
		return project_code;
	}

	public void setProject_code(String project_code) {
		this.project_code = project_code;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassport_no() {
		return passport_no;
	}

	public void setPassport_no(String passport_no) {
		this.passport_no = passport_no;
	}

	public Date getPassport_issue_date() {
		return passport_issue_date;
	}

	public void setPassport_issue_date(Date passport_issue_date) {
		this.passport_issue_date = passport_issue_date;
	}

	public Date getPassport_expiry_date() {
		return passport_expiry_date;
	}

	public void setPassport_expiry_date(Date passport_expiry_date) {
		this.passport_expiry_date = passport_expiry_date;
	}

	public String getTax_id() {
		return tax_id;
	}

	public void setTax_id(String tax_id) {
		this.tax_id = tax_id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getEmp_role() {
		return emp_role;
	}

	public void setEmp_role(String emp_role) {
		this.emp_role = emp_role;
	}

	public String getManager_nm() {
		return manager_nm;
	}

	public void setManager_nm(String manager_nm) {
		this.manager_nm = manager_nm;
	}

	public String getSun_employee_id() {
		return sun_employee_id;
	}

	public void setSun_employee_id(String sun_employee_id) {
		this.sun_employee_id = sun_employee_id;
	}

	public String getOld_id() {
		return old_id;
	}

	public void setOld_id(String old_id) {
		this.old_id = old_id;
	}

	public String getEr() {
		return er;
	}

	public void setEr(String er) {
		this.er = er;
	}

	public String getOld_er() {
		return old_er;
	}

	public void setOld_er(String old_er) {
		this.old_er = old_er;
	}

	public String getCost_center() {
		return cost_center;
	}

	public void setCost_center(String cost_center) {
		this.cost_center = cost_center;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getTransaction_prefix() {
		return transaction_prefix;
	}

	public void setTransaction_prefix(String transaction_prefix) {
		this.transaction_prefix = transaction_prefix;
	}

	public String getThird_party() {
		return third_party;
	}

	public void setThird_party(String third_party) {
		this.third_party = third_party;
	}

	public String getExport_to_open_air() {
		return export_to_open_air;
	}

	public void setExport_to_open_air(String export_to_open_air) {
		this.export_to_open_air = export_to_open_air;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getOa_department() {
		return oa_department;
	}

	public void setOa_department(String oa_department) {
		this.oa_department = oa_department;
	}

	public String getExpense_currency() {
		return expense_currency;
	}

	public void setExpense_currency(String expense_currency) {
		this.expense_currency = expense_currency;
	}

	public String getLogin_access() {
		return login_access;
	}

	public void setLogin_access(String login_access) {
		this.login_access = login_access;
	}

	public String getJob_level() {
		return job_level;
	}

	public void setJob_level(String job_level) {
		this.job_level = job_level;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public Date getTermination_date() {
		return termination_date;
	}

	public void setTermination_date(Date termination_date) {
		this.termination_date = termination_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
