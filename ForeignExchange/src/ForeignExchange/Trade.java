package ForeignExchange;

import java.text.DecimalFormat;

public class Trade {

	private static int tradeCounter = 0;
	private double rate;
	private int tradeNumber;
	private String customerName;
	private String currencyPair;
	private double amount;
	
	public Trade( String customerName, String currencyPair, double amount,double rate ) {
		this.tradeNumber = ++tradeCounter;
        this.customerName = customerName;
        this.currencyPair = currencyPair;
        this.amount = amount;
        this.rate = rate;
	}
	
	public String customerName() {
		return customerName;
	}
	
	public String currencyPair() {
		return currencyPair;
	}
	
	public double rate() {
		return rate;
	}
	
	public double amount() {
		return amount;
	}
	
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
        String formattedAmount = "INR " + df.format(rate*amount);
        return tradeNumber + "\t    " + currencyPair + "\t\t" + customerName + "\t"+ formattedAmount + "\t" + amount;
	}
		 
}
