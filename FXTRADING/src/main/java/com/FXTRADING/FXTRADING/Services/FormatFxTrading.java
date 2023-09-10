package com.FXTRADING.FXTRADING.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.FXTRADING.FXTRADING.Model.Trade;

@Service
public class FormatFxTrading{
	
	private static List<Trade> bookedTrade = new ArrayList<>();

	public static Object doTrade(Trade trade) {
		
		Map<String , String> userError = new TreeMap<>();
		
		if(trade.getCustomerName().isBlank())
		{
			userError.put("Customer-Name", "Customer name cannot be empty");
		}
		if(trade.getAmount()<=0)
		{
			userError.put("USD-Amount", "Amount cannot be Negative");
		}
		if(!trade.getCurrencyPair().equals("USDINR"))
		{
			userError.put("Currency-Pair", "Currency pair is not USDINR");
		}
		
		if(userError.isEmpty())
		{
			double indianAmount=trade.getAmount()*trade.getRate();
			trade.setAmount(indianAmount);
			
			Trade trade1 = new Trade(trade.getCustomerName(), trade.getCurrencyPair(), trade.getAmount());
			userError.put("message", "Trade for " + trade.getCurrencyPair()+ "has been booked with rate " + trade.getRate() + "The amount of Rs " + trade.getAmount()+ "will be transferred in 2 working days to " + trade.getCustomerName());
	          
			bookedTrade.add(trade1);
			return trade;
		}
		else {
			return userError;
		}
		
	}


	public List<Trade> getTradeList() {
		
		return this.bookedTrade;
	}
	
	
}
