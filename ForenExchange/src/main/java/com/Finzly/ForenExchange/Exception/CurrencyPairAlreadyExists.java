package com.Finzly.ForenExchange.Exception;

public class CurrencyPairAlreadyExists extends RuntimeException {

	public CurrencyPairAlreadyExists()
	{
		super("Currency Pair Already Exists");
	}
}
