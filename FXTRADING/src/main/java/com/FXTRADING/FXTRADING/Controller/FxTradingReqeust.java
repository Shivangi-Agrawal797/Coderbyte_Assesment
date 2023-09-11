package com.Fxtrading.FXTrading.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fxtrading.FXTrading.Model.Trade;
import com.Fxtrading.FXTrading.Service.FormatFxTrading;

@RestController
@RequestMapping("Trade")
public class FxTradingReqeus {
	@Autowired
	private FormatFxTrading formatFxTrading;
	/**
	 * Endpoint for booking a trade Specify the HTTP method and endpoint path
	 */
	@PostMapping ("/dotrade")
	public Object doTrading(@RequestBody Trade trade) {
		return FormatFxTrading.doTrade(trade);
	}
	/**
	 * Endpoint for retrieving trades Specify the HTTP method and endpoint path
	 */
	@GetMapping("/gettrades")
	public Object getAllTrades() {
		List<Trade> tradeList = this.formatFxTrading.getTradeList();
		if (tradeList.isEmpty()) {
			return "Your trade List is Empty";
		} else {
			return tradeList;
		}
	}
}
