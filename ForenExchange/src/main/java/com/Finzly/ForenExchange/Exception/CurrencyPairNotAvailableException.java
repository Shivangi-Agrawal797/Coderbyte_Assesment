package com.Finzly.ForenExchange.Exception;

public class CurrencyPairNotAvailableException extends RuntimeException {

	public CurrencyPairNotAvailableException() {
		super("This Currency PAir is Not available");
	}
}
