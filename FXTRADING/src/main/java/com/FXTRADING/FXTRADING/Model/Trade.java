package com.FXTRADING.FXTRADING.Model;

import io.micrometer.common.lang.NonNull;

public class Trade {

	private static int tradeCounter = 1;
	private double rate = 66.0;
	private int tradeNumber;
	private String customerName;
	private String currencyPair;
	private double amount;
	
	
	Trade(){
		
	}

    public Trade(String customerName, String currencyPair, double amount) {
		super();
		this.tradeNumber = tradeCounter++;
		this.customerName = customerName;
		this.currencyPair = currencyPair;
		this.amount = amount;
	}

    
    @NonNull
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getTradeNumber() {
		return tradeNumber;
	}

	public void setTradeNumber(int tradeNumber) {
		this.tradeNumber = tradeNumber;
	}

	public  String getCustomerName() {
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

	
	@Override
	public String toString() {
		return "Trade [rate=" + rate + ", tradeNumber=" + tradeNumber + ", customerName=" + customerName
				+ ", currencyPair=" + currencyPair + ", amount=" + amount + "]";
	}
	

	
    
	
}
