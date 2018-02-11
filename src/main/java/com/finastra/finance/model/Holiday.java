package com.finastra.finance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="holiday")
@Table(name = "tbl_holidays")
public class Holiday 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "holiday_id")
	private int holiday_id;
	
	@DateTimeFormat(pattern = "dd-MMM-yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "date")
	@NotNull(message = "*Date is Mandatory")
	private Date date;
	
	@Column(name = "description")
	@NotEmpty(message = "*This field is required")
	private String description;

	public int getHoliday_id() {
		return holiday_id;
	}
	
	public Holiday() {
		super();
	}

	public Holiday(int holiday_id, Date date, String description) {
		super();
		this.holiday_id = holiday_id;
		this.date = date;
		this.description = description;
	}

	public void setHoliday_id(int holiday_id) {
		this.holiday_id = holiday_id;
	}

	@Override
	public String toString() {
		return "Holiday [holiday_id=" + holiday_id + ", date=" + date + ", description=" + description + "]";
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
}
