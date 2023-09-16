package com.Finzly.ForenExchange.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Finzly.ForenExchange.Model.FxTrade;
import com.Finzly.ForenExchange.Service.FxTradeService;

@RestController
@RequestMapping("trade")
public class FxTradeController {

	@Autowired
	FxTradeService fxTradeService;
	
	/*
	 * @Author Shivangi Agrawal 
	 * This endpoint allows clients to perform a trade operation.
     * It takes a JSON request body containing trade information and returns a message.
     *
	 */
	@PostMapping("dotrade")
	public String bookTrade(@RequestBody FxTrade fxTrade) 
	{
		
		try {
			fxTradeService.bookTrade(fxTrade);
			return "Trade booked sucessfully!!!!!!";
		} 
		catch (RuntimeException exception) {
			exception.printStackTrace();
			return exception.getMessage();
		}	
	}
	
	/*
	 *      This endpoint allows clients to retrieve a list of booked trades.
     *
	 */
	@GetMapping("BookedTradeList")
	public Object getBookedTradeList() 
	{
		return fxTradeService.getBookedTradeList();	
	}
}
