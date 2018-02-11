package com.finastra.finance.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "itinerary")
@Table(name = "tbl_itinerary")
public class Itinerary 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "itinerary_id")
	@NotNull
	private int itinerary_id;
	
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "departure_dt")
	@NotNull(message = "*This field is required")
	private Date departure_dt;
	
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "return_dt")
	@NotNull(message = "*This field is required")
	private Date return_dt;
	
	@Column(name = "food_days")
	private int food_days;
	
	@Column(precision=13, scale=2, name="food_per_day")
	@NotNull(message = "*This field is required")
	private BigDecimal food_per_day;
	
	@Column(precision=13, scale=2, name="food_total_amt")
	@NotNull(message = "*This field is required")
	private BigDecimal food_total_amt;
	
	@Column(name = "food_cur")
	@NotEmpty(message = "*This field is required")
	private String food_cur;
	
	@Column(name = "local_conveyance_days")
	private int local_conveyance_days;
	
	@Column(precision=13, scale=2, name="local_conveyance_per_day")
	@NotNull(message = "*This field is required")
	private BigDecimal local_conveyance_per_day;
	
	@Column(precision=13, scale=2, name="local_conveyance_total_amt")
	@NotNull(message = "*This field is required")
	private BigDecimal local_conveyance_total_amt;
	
	@Column(name = "local_conveyance_cur")
	@NotEmpty(message = "*This field is required")
	private String local_conveyance_cur;
	
	@Column(name = "dest_city")
	@NotEmpty(message = "*This field is required")
	private String dest_city;
	
	@Column(name = "hotel_days")
	private int hotel_days;
	
	@Column(precision=13, scale=2, name="hotel_per_day")
	@NotNull(message = "*This field is required")
	private BigDecimal hotel_per_day;
	
	@Column(precision=13, scale=2, name="hotel_total_amt")
	@NotNull(message = "*This field is required")
	private BigDecimal hotel_total_amt;
	
	@Column(name = "hotel_cur")
	@NotEmpty(message = "*This field is required")
	private String hotel_cur;
	
	@Column(name = "dest_country")
	@NotEmpty(message = "*This field is required")
	private String dest_country;
	
	@Column(name = "othr_days")
	private int othr_days;
	
	@Column(precision=13, scale=2, name="othr_per_day")
	@NotNull(message = "*This field is required")
	private BigDecimal othr_per_day;
	
	@Column(precision=13, scale=2, name="othr_total_amt")
	@NotNull(message = "*This field is required")
	private BigDecimal othr_total_amt;
	
	@Column(name = "othr_cur")
	@NotEmpty(message = "*This field is required")
	private String othr_cur;
	
	@Column(name = "itr_cur")
	private String itr_cur;
	
	@Column(precision=13, scale=2, name="itr_total_amt")
	private BigDecimal itr_total_amt;
	
	@Column(precision=13, scale=2, name="amt_in_cash")
	private BigDecimal amt_in_cash;
	
	@Column(precision=13, scale=2, name="amt_on_card")
	private BigDecimal amt_on_card;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "forex_id")
	private Forex forex;

	public Forex getForex() {
		return forex;
	}

	public void setForex(Forex forex) {
		this.forex = forex;
	}

	public int getItinerary_id() {
		return itinerary_id;
	}

	public void setItinerary_id(int itinerary_id) {
		this.itinerary_id = itinerary_id;
	}

	public Date getDeparture_dt() {
		return departure_dt;
	}

	public void setDeparture_dt(Date departure_dt) {
		this.departure_dt = departure_dt;
	}

	public Date getReturn_dt() {
		return return_dt;
	}

	public void setReturn_dt(Date return_dt) {
		this.return_dt = return_dt;
	}

	public int getFood_days() {
		return food_days;
	}

	public void setFood_days(int food_days) {
		this.food_days = food_days;
	}

	public BigDecimal getFood_per_day() {
		return food_per_day;
	}

	public void setFood_per_day(BigDecimal food_per_day) {
		this.food_per_day = food_per_day;
	}

	public BigDecimal getFood_total_amt() {
		return food_total_amt;
	}

	public void setFood_total_amt(BigDecimal food_total_amt) {
		this.food_total_amt = food_total_amt;
	}

	public String getFood_cur() {
		return food_cur;
	}

	public void setFood_cur(String food_cur) {
		this.food_cur = food_cur;
	}

	public int getLocal_conveyance_days() {
		return local_conveyance_days;
	}

	public void setLocal_conveyance_days(int local_conveyance_days) {
		this.local_conveyance_days = local_conveyance_days;
	}

	public BigDecimal getLocal_conveyance_per_day() {
		return local_conveyance_per_day;
	}

	public void setLocal_conveyance_per_day(BigDecimal local_conveyance_per_day) {
		this.local_conveyance_per_day = local_conveyance_per_day;
	}

	public BigDecimal getLocal_conveyance_total_amt() {
		return local_conveyance_total_amt;
	}

	public void setLocal_conveyance_total_amt(BigDecimal local_conveyance_total_amt) {
		this.local_conveyance_total_amt = local_conveyance_total_amt;
	}

	public String getLocal_conveyance_cur() {
		return local_conveyance_cur;
	}

	public void setLocal_conveyance_cur(String local_conveyance_cur) {
		this.local_conveyance_cur = local_conveyance_cur;
	}

	public String getDest_city() {
		return dest_city;
	}

	public void setDest_city(String dest_city) {
		this.dest_city = dest_city;
	}

	public int getHotel_days() {
		return hotel_days;
	}

	public void setHotel_days(int hotel_days) {
		this.hotel_days = hotel_days;
	}

	public BigDecimal getHotel_per_day() {
		return hotel_per_day;
	}

	public void setHotel_per_day(BigDecimal hotel_per_day) {
		this.hotel_per_day = hotel_per_day;
	}

	public BigDecimal getHotel_total_amt() {
		return hotel_total_amt;
	}

	public void setHotel_total_amt(BigDecimal hotel_total_amt) {
		this.hotel_total_amt = hotel_total_amt;
	}

	public String getHotel_cur() {
		return hotel_cur;
	}

	public void setHotel_cur(String hotel_cur) {
		this.hotel_cur = hotel_cur;
	}

	public String getDest_country() {
		return dest_country;
	}

	public void setDest_country(String dest_country) {
		this.dest_country = dest_country;
	}

	public int getOthr_days() {
		return othr_days;
	}

	public void setOthr_days(int othr_days) {
		this.othr_days = othr_days;
	}

	public BigDecimal getOthr_per_day() {
		return othr_per_day;
	}

	public void setOthr_per_day(BigDecimal othr_per_day) {
		this.othr_per_day = othr_per_day;
	}

	public BigDecimal getOthr_total_amt() {
		return othr_total_amt;
	}

	public void setOthr_total_amt(BigDecimal othr_total_amt) {
		this.othr_total_amt = othr_total_amt;
	}

	public String getOthr_cur() {
		return othr_cur;
	}

	public String getItr_cur() {
		return itr_cur;
	}

	public void setItr_cur(String itr_cur) {
		this.itr_cur = itr_cur;
	}

	public BigDecimal getItr_total_amt() {
		return itr_total_amt;
	}

	public void setItr_total_amt(BigDecimal itr_total_amt) {
		this.itr_total_amt = itr_total_amt;
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

	public void setOthr_cur(String othr_cur) {
		this.othr_cur = othr_cur;
	}

	public String toJson() {
		return "{\"itinerary_id\":\"" + itinerary_id + "\", \"departure_dt\":\"" + departure_dt + "\", \"return_dt\":\"" + return_dt
				+ "\", \"food_days\":\"" + food_days + "\", \"food_per_day\":\"" + food_per_day + "\", \"food_total_amt\":\""
				+ food_total_amt + "\", \"food_cur\":\"" + food_cur + "\", \"local_conveyance_days\":\"" + local_conveyance_days
				+ "\", \"local_conveyance_per_day\":\"" + local_conveyance_per_day + "\", \"local_conveyance_total_amt\":\""
				+ local_conveyance_total_amt + "\", \"local_conveyance_cur\":\"" + local_conveyance_cur + "\", \"dest_city\":\""
				+ dest_city + "\", \"hotel_days\":\"" + hotel_days + "\", \"hotel_per_day\":\"" + hotel_per_day + "\", \"hotel_total_amt\":\""
				+ hotel_total_amt + "\", \"hotel_cur\":\"" + hotel_cur + "\", \"dest_country\":\"" + dest_country + "\", \"othr_days\":\""
				+ othr_days + "\", \"othr_per_day\":\"" + othr_per_day + "\", \"othr_total_amt\":\"" + othr_total_amt + "\", \"othr_cur\":\""
				+ othr_cur + "\"}";
	}
	
}
