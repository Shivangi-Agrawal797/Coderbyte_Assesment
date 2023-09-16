package com.Finzly.ForenExchange.Exception;

public class CustomException {

	public static void CurrencyPairNotAvailableException() {
		throw new CurrencyPairNotAvailableException();
	}

	public static void NegativeAmountException() {
		throw new NegativeAmountException();
		
	}

	public static void currencyPairAlreadyExists() {
		throw new CurrencyPairAlreadyExists();		
	}

	public static void improperCurrencyPairFormatException() {
		throw new improperCurrencyPairFormatException();
		
	}

}
