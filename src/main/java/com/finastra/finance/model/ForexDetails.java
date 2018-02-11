package com.finastra.finance.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity (name = "forexDetails")
@Table(name = "tbl_forex_details")
public class ForexDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "forex_dtls_id")
	@NotNull
	private int forex_dtls_id;
	
	@Column(precision=13, scale=2, name="amt_in_cash")
	private BigDecimal amt_in_cash;
	
	@Column(precision=13, scale=2, name="amt_on_card")
	private BigDecimal amt_on_card;
	
	@Column(precision=13, scale=2, name="total_amt")
	private BigDecimal total_amt;
	
	@Column(name = "currency")
	private String currency;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "forex_id")
	private Forex forex;

	public int getForex_dtls_id() {
		return forex_dtls_id;
	}

	public void setForex_dtls_id(int forex_dtls_id) {
		this.forex_dtls_id = forex_dtls_id;
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

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Forex getForex() {
		return forex;
	}

	public void setForex(Forex forex) {
		this.forex = forex;
	}
	
}
