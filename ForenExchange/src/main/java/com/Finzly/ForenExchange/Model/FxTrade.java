package com.Finzly.ForenExchange.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FxTrade {
	
//	private static int tradeCounter = 1;
//	private double rate = 66.0;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tradeNumber;
	private String customerName;
	private String currencyPair;
	private double amount;
	
	
	public int getTradeNumber() {
		return tradeNumber;
	}
	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	//Constructor to initialize the FxExchangeInfo object with trade details
	public FxTrade(int tradeNumber, String customerName, String currencyPair, double amount) {
		super();
		this.tradeNumber = tradeNumber;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "FxTrade [tradeNumber=" + tradeNumber + ", customerName=" + customerName + ", currencyPair="
				+ currencyPair + ", amount=" + amount + "]";
	}
	
	
	

}
