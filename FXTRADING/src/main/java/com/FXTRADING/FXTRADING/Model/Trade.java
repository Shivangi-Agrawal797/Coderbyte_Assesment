package com.FXTRADING.FXTRADING.Model;

import io.micrometer.common.lang.NonNull;

public class Trade {
    /*
     * attributes
     */
	private static int tradeCounter = 1;
	private double rate = 66.0;
	private int tradeNumber;
	private String customerName;
	private String currencyPair;
	private double amount;
	
	//Default constructor
	public Trade () {
	}
	
	//Parameterized constructor
	public Trade(String customerName, String currencyPair, double amount) {
		super();
		this.tradeNumber = tradeCounter++;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
	}
	
	
	//Getter methods for retrieving field values
	public double getRate() {
		return rate;
	}
	public int getTradeNumber() {
		return tradeNumber;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getCurrencyPair() {
		return currencyPair;
	}
	public double getAmount() {
		return amount;
	}
	
	// Setter method for updating field
	public void setRate(double rate) {
		this.rate = rate;
	}
	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public void setCurrencyPair(String currencyPair) {
		this.currencyPair = currencyPair;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	//toString method overriding
	@Override
	public String toString() {
		return "Trade [rate=" + rate + ", "
				+ "tradeNumber=" + tradeNumber + ", "
				+ "customerName=" + customerName
				+ ", currencyPair=" + currencyPair 
				+ ", amount=" + amount + "]";
	}	
}
