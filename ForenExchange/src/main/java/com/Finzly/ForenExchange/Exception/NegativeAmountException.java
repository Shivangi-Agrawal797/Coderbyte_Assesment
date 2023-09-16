package com.Finzly.ForenExchange.Exception;

public class NegativeAmountException extends RuntimeException{

	public NegativeAmountException()
	{
		super("Amount cannot be negative");
	}
}
