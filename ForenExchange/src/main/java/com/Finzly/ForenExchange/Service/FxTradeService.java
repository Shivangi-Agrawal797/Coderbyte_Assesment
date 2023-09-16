package com.Finzly.ForenExchange.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Finzly.ForenExchange.Dao.CurrencyDao;
import com.Finzly.ForenExchange.Dao.FxTradeDao;
import com.Finzly.ForenExchange.Exception.CustomException;
import com.Finzly.ForenExchange.Model.FxTrade;
import com.Finzly.ForenExchange.Utility.TradeAmountConversion;

@Service
public class FxTradeService {

	@Autowired
	CurrencyDao currencyDao;
	@Autowired
	TradeAmountConversion tradeAmountConversion;
	@Autowired
	FxTradeDao fxTradeDao;

	/* This method executes a trade operation, converting the amount and saving the trade information in the database.
	    * It checks if the currency pair is available and if the amount is not negative.
	    * Throws RuntimeException in case of issues.
	    */
	public void bookTrade(FxTrade fxTrade) {
		Object checkCurrency = currencyDao.checkcurrencyPair(fxTrade.getCurrencyPair());;
		if(checkCurrency==null) {
			CustomException.CurrencyPairNotAvailableException();
			
		}
		else if(fxTrade.getAmount()<0){
			CustomException.NegativeAmountException();
		}
		
		double convertedamount=tradeAmountConversion.convertFromTo(fxTrade.getCurrencyPair(),fxTrade.getAmount());
		fxTrade.setAmount(convertedamount);
		fxTradeDao.addTrade(fxTrade);
	}


	/*
	 *   This method retrieves a list of booked trades.
     * If the list is empty, it returns a message indicating that the trade list is empty.
     */
	public Object getBookedTradeList() {
		List<FxTrade> tradelist = fxTradeDao.getBookedTradeList();
		if(tradelist.isEmpty()) {
			return "Tradelist is Empty"; 
		}
		else {
			return tradelist;
		}
	}

}

