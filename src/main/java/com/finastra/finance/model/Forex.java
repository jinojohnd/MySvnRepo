package com.finastra.finance.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="forex")
@Table(name = "tbl_forex")
public class Forex 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "forex_id")
	private int forex_id;
	
	@Column(name = "emp_type")
	@NotEmpty(message = "*Employee Type is Mandatory")
	private String emp_type;
	
	@Column(name = "emp_nm")
	@NotEmpty(message = "*This field is required")
	private String emp_nm;
	
	@Column(name = "mother_nm")
	@NotEmpty(message = "*This field is required")
	private String mother_nm;
	
	@Column(name = "email")
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*This field is required")
	private String email;
	
	@Column(name = "mobile")
	@NotNull(message = "*This field is required")
	private String mobile;
	
	@Column(name = "manager_nm")
	@NotEmpty(message = "*This field is required")
	private String manager_nm;
	
	@Column(name = "forex_card")
	private int forex_card;
	
	@Column(name = "purpose_of_trip")
	@NotEmpty(message = "*This field is required")
	private String purpose_of_trip;
	
	@Column(name = "billable")
	@NotEmpty(message = "*This field is required")
	private String billable;
	
	@Column(name = "proj_code")
	@NotEmpty(message = "*This field is required")
	private String proj_code;
	
	@Column(name = "proj_nm")
	@NotEmpty(message = "*This field is required")
	private String proj_nm;
	
	@Column(name = "opp_num")
	@NotEmpty(message = "*This field is required")
	private String opp_num;
	
	@Column(name = "client_nm")
	@NotEmpty(message = "*This field is required")
	private String client_nm;
	
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "dob_dt")
	@NotNull(message = "*This field is required")
	private Date dob_dt;
	
	@Column(name = "add_line_1")
	@NotEmpty(message = "*This field is required")
	private String add_line_1;
	
	@Column(name = "add_line_2")
	@NotEmpty(message = "*This field is required")
	private String add_line_2;
	
	@Column(name = "add_line_3")
	@NotEmpty(message = "*This field is required")
	private String add_line_3;
	
	@Column(name = "passport_num")
	@NotEmpty(message = "*This field is required")
	private String passport_num;
	
	@Column(name = "passport_iss_dt")
	@NotNull(message = "*This field is required")
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date passport_iss_dt;
	
	@Column(name = "passport_exp_dt")
	@NotNull(message = "*This field is required")
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	@Temporal(TemporalType.DATE)
	private Date passport_exp_dt;
	
	@Column(name = "city")
	@NotEmpty(message = "*This field is required")
	private String city;
	
	@Column(name = "uid")
	@NotEmpty(message = "*This field is required")
	private String uid;
	
	@Column(name = "request_type")
	@NotEmpty(message = "*This field is required")
	private String request_type;
	
	@Column(precision=13, scale=4, name="amt_in_cash")
	@NotNull(message = "*This field is required")
	private BigDecimal amt_in_cash;
	
	@Column(precision=13, scale=4, name="amt_on_card")
	@NotNull(message = "*This field is required")
	private BigDecimal amt_on_card;
	
	@Column(precision=13, scale=4, name="total_amt")
	@NotNull(message = "*This field is required")
	private BigDecimal total_amt;
	
	@Column(name = "comments")
	private String comments;
		
	@OneToMany(mappedBy = "forex", cascade = CascadeType.ALL)
	List<Itinerary> itineraryLst = new ArrayList<Itinerary>();
	
	public Forex(int forex_id, String emp_type, String emp_nm, String mother_nm, String email, String mobile,
			String manager_nm, int forex_card, String purpose_of_trip, String billable, String proj_code,
			String proj_nm, String opp_num, String client_nm, Date dob_dt, String add_line_1, String add_line_2,
			String add_line_3, String passport_num, Date passport_iss_dt, Date passport_exp_dt, String city, String uid,
			String request_type, BigDecimal amt_in_cash, BigDecimal amt_on_card, BigDecimal total_amt, String comments,
			List<Itinerary> itineraryLst) {
		super();
		this.forex_id = forex_id;
		this.emp_type = emp_type;
		this.emp_nm = emp_nm;
		this.mother_nm = mother_nm;
		this.email = email;
		this.mobile = mobile;
		this.manager_nm = manager_nm;
		this.forex_card = forex_card;
		this.purpose_of_trip = purpose_of_trip;
		this.billable = billable;
		this.proj_code = proj_code;
		this.proj_nm = proj_nm;
		this.opp_num = opp_num;
		this.client_nm = client_nm;
		this.dob_dt = dob_dt;
		this.add_line_1 = add_line_1;
		this.add_line_2 = add_line_2;
		this.add_line_3 = add_line_3;
		this.passport_num = passport_num;
		this.passport_iss_dt = passport_iss_dt;
		this.passport_exp_dt = passport_exp_dt;
		this.city = city;
		this.uid = uid;
		this.request_type = request_type;
		this.amt_in_cash = amt_in_cash;
		this.amt_on_card = amt_on_card;
		this.total_amt = total_amt;
		this.comments = comments;
		this.itineraryLst = itineraryLst;
	}

	public Forex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Forex(String emp_type, String emp_nm, String manager_nm, BigDecimal total_amt) {
		super();
		this.emp_type = emp_type;
		this.emp_nm = emp_nm;
		this.manager_nm = manager_nm;
		this.total_amt = total_amt;
	}

	public Date getDob_dt() {
		return dob_dt;
	}

	public void setDob_dt(Date dob_dt) {
		this.dob_dt = dob_dt;
	}

	public List<Itinerary> getItineraryLst() {
		return itineraryLst;
	}

	public void setItineraryLst(List<Itinerary> itineraryLst) {
		this.itineraryLst = itineraryLst;
	}

	public int getForex_id() {
		return forex_id;
	}

	public void setForex_id(int forex_id) {
		this.forex_id = forex_id;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	public String getEmp_nm() {
		return emp_nm;
	}

	public void setEmp_nm(String emp_nm) {
		this.emp_nm = emp_nm;
	}

	public String getMother_nm() {
		return mother_nm;
	}

	public void setMother_nm(String mother_nm) {
		this.mother_nm = mother_nm;
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

	public String getManager_nm() {
		return manager_nm;
	}

	public void setManager_nm(String manager_nm) {
		this.manager_nm = manager_nm;
	}

	public int getForex_card() {
		return forex_card;
	}

	public void setForex_card(int forex_card) {
		this.forex_card = forex_card;
	}

	public String getPurpose_of_trip() {
		return purpose_of_trip;
	}

	public void setPurpose_of_trip(String purpose_of_trip) {
		this.purpose_of_trip = purpose_of_trip;
	}

	public String getBillable() {
		return billable;
	}

	public void setBillable(String billable) {
		this.billable = billable;
	}

	public String getProj_code() {
		return proj_code;
	}

	public void setProj_code(String proj_code) {
		this.proj_code = proj_code;
	}

	public String getProj_nm() {
		return proj_nm;
	}

	public void setProj_nm(String proj_nm) {
		this.proj_nm = proj_nm;
	}

	public String getOpp_num() {
		return opp_num;
	}

	public void setOpp_num(String opp_num) {
		this.opp_num = opp_num;
	}

	public String getClient_nm() {
		return client_nm;
	}

	public void setClient_nm(String client_nm) {
		this.client_nm = client_nm;
	}

	public Date getdob_dt() {
		return dob_dt;
	}

	public void setdob_dt(Date dob_dt) {
		this.dob_dt = dob_dt;
	}

	public String getAdd_line_1() {
		return add_line_1;
	}

	public void setAdd_line_1(String add_line_1) {
		this.add_line_1 = add_line_1;
	}

	public String getAdd_line_2() {
		return add_line_2;
	}

	public void setAdd_line_2(String add_line_2) {
		this.add_line_2 = add_line_2;
	}

	public String getAdd_line_3() {
		return add_line_3;
	}

	public void setAdd_line_3(String add_line_3) {
		this.add_line_3 = add_line_3;
	}

	public String getPassport_num() {
		return passport_num;
	}

	public void setPassport_num(String passport_num) {
		this.passport_num = passport_num;
	}

	public Date getPassport_iss_dt() {
		return passport_iss_dt;
	}

	public void setPassport_iss_dt(Date passport_iss_dt) {
		this.passport_iss_dt = passport_iss_dt;
	}

	public Date getPassport_exp_dt() {
		return passport_exp_dt;
	}

	public void setPassport_exp_dt(Date passport_exp_dt) {
		this.passport_exp_dt = passport_exp_dt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getRequest_type() {
		return request_type;
	}

	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}

	public BigDecimal getAmt_in_cash() {
		return amt_in_cash;
	}

	public void setAmt_in_cash(BigDecimal amt_in_cash) {
		this.amt_in_cash = amt_in_cash;
	}

	public BigDecimal getAmt_on_card() {
		return amt_on_card;
	}

	public void setAmt_on_card(BigDecimal amt_on_card) {
		this.amt_on_card = amt_on_card;
	}

	public BigDecimal getTotal_amt() {
		return total_amt;
	}

	public void setTotal_amt(BigDecimal total_amt) {
		this.total_amt = total_amt;
	}
	
	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public void addItinerary(Itinerary itinerary)
	{
		itineraryLst.add(itinerary);
		itinerary.setForex(this);
	}
}
