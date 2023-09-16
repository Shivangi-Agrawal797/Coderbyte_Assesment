package com.Finzly.ForenExchange.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Finzly.ForenExchange.Dao.CurrencyDao;
import com.Finzly.ForenExchange.Exception.CustomException;
import com.Finzly.ForenExchange.Model.Currency;
import com.Finzly.ForenExchange.Utility.TradeAmountConversion;

@Service
public class CurrencyService {
	
	@Autowired
	CurrencyDao ccyDao;

	@Autowired
	TradeAmountConversion tradeAmountConversion;

	//This method adds a new currency exchange pair with the specified conversion rate.
	public void addCurrencyExchange(String currencyRate) {
		
		String[] splitCurrencyPair=currencyRate.split("=");
		Double convertedRate;
		if(splitCurrencyPair.length==2)
		{
			String currencyPair=splitCurrencyPair[0];
			String rate=splitCurrencyPair[1];
			
			Object check=ccyDao.checkcurrencyPair(currencyPair);
			if(check==null)
			{
				 Currency currencyExchangerObj = new Currency();
				try {
					 convertedRate=Double.parseDouble(rate);
				}
				catch(NumberFormatException e) {
					throw e;
				}
				if(convertedRate<0) {
					CustomException.NegativeAmountException();
				}
				currencyExchangerObj.setCcyrate(convertedRate);
				currencyExchangerObj.setCurrencyPair(currencyPair);
				String status=ccyDao.addCurrencyExchange(currencyExchangerObj);
				
			}
			else {
				CustomException.currencyPairAlreadyExists();
			}
		}
		else {
			CustomException.improperCurrencyPairFormatException();
		}			
	}

	//This method retrieves all currency pairs.
	public Object getAllCurrencyPair() {
		List<Currency>currencyExchanges=ccyDao.getAllCurrencyPair();
		if(currencyExchanges.isEmpty()) {
			return "Your CurrencyPair List is Empty";
		}
		else {
			return currencyExchanges;
		}
	}

	//This method updates an existing currency exchange pair with the specified conversion rate.
	public void updateCurrencyPairRate(String ccyRate) {
		String[] splitCurrencyPair=ccyRate.split("=");
		Double convertedRate;
		if(splitCurrencyPair.length==2)
		{
			String currencyPair=splitCurrencyPair[0];
			String rate=splitCurrencyPair[1];
			
			Object check=ccyDao.checkcurrencyPair(currencyPair);
			if(check!=null)
			{
				Currency currencyExchangerObj=new Currency();
				try {
					 convertedRate=Double.parseDouble(rate);
				}
				catch(NumberFormatException e) {
					throw e;
				}
				if(convertedRate<0) {
					CustomException.NegativeAmountException();
				}
				
				currencyExchangerObj.setCcyrate(convertedRate);
				currencyExchangerObj.setCurrencyPair(currencyPair);
				String status = ccyDao.updateCurrencyPair(currencyExchangerObj);
				
			}
			else {
				CustomException.CurrencyPairNotAvailableException();
			}
		}
		else {
			CustomException.improperCurrencyPairFormatException();
		}
		
	}		
}


