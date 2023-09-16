package com.Finzly.ForenExchange.Utility;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Finzly.ForenExchange.Dao.CurrencyDao;
import com.Finzly.ForenExchange.Model.Currency;

@Component
public class TradeAmountConversion {

	@Autowired
	CurrencyDao CurrencyExchangeDao;
	
	// This utility method converts the given amount from one currency pair to another using the conversion rate.
	public double convertFromTo(String currencyPair,double amount)
		{
			List<Currency> currencyPairList=CurrencyExchangeDao.getCurrencyPairRate(currencyPair);
			double conversionRate=currencyPairList.get(0).getCcyrate();
			double convertedAmount=amount*conversionRate;
			return convertedAmount;
			
		}
	}


