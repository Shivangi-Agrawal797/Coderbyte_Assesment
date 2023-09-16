package com.Finzly.ForenExchange.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ccyId;
	private String CurrencyPair;
	private double ccyrate;

	
	
	public Currency() {
		super();
	}
	
	//Constructor to initialize the CurrencyInfo object with currency pair details
	public Currency(int ccyId, String currencyPair, double ccyrate) {
		super();
		this.ccyId = ccyId;
		CurrencyPair = currencyPair;
		this.ccyrate = ccyrate;
	}

	public int getCcyId() {
		return ccyId;
	}
	public void setCcyId(int ccyId) {
		this.ccyId = ccyId;
	}
	
	public String getCurrencyPair() {
		return CurrencyPair;
	}
	public void setCurrencyPair(String CurrencyPair) {
		this.CurrencyPair = CurrencyPair;
	}
	
	public double getCcyrate() {
		return ccyrate;
	}
	public void setCcyrate(double ccyrate) {
		this.ccyrate = ccyrate;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Currency [ccyId=" + ccyId + ", currencyPair=" + CurrencyPair + ", ccyrate=" + ccyrate + "]";
	}
	
}
