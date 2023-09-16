package com.Finzly.ForenExchange.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Finzly.ForenExchange.Service.CurrencyService;

@RestController
public class CurrencyController {
	
	Logger logger = LoggerFactory.getLogger(CurrencyController.class);
	@Autowired
	CurrencyService ccyService;
	
	//Endpoint to add a new currency exchange pair with the specified conversion rate.
	@PostMapping("currency-exchange/{currencyrate}")
	public String addCurrencyExchange(@PathVariable String currencyrate) {
		try {
			//Call the addCurrencyExhange method of the CurrencyService 
			ccyService.addCurrencyExchange(currencyrate);
			
			//If successful ,return a success message
			return "Currency Pair Added Succesfully";
		} catch (RuntimeException e) {
			
			//If a Exception of type Runtime Exception is thrown, catch it 
			e.printStackTrace();
			//return the exception message as a response
			return e.getMessage();
		}
	}
	
	/*
	 *  Endpoint to retrieve all currency pairs.
	 */
	@GetMapping("getAllCurrencyPair")
	public Object getAllCurrencyPair() {
		//logger.info("currency pair list is"+ccyService.getAllCurrencyPair());
		return ccyService.getAllCurrencyPair();
	}

	//Endpoint to update an existing currency pair.
	@PutMapping("updateExistingCcy/{ccy}")
	public void updateExistingCcy(@PathVariable String ccy) {
		ccyService.updateCurrencyPairRate(ccy);
	}

}
