
package com.FXTRADING.FXTRADING.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FXTRADING.FXTRADING.Model.Trade;
import com.FXTRADING.FXTRADING.Services.FormatFxTrading;

@RestController
public class FxTradingReqeust {
	
	@Autowired
	private FormatFxTrading formatFxTrading;
	
	@PostMapping ("dotrade")
	public Object doTrading(@RequestBody Trade trade) {

		return FormatFxTrading.doTrade(trade);

	}

	@GetMapping("gettrades")
	public Object getAllTrades() {
		List<Trade> tradeList = this.formatFxTrading.getTradeList();
		if (tradeList.isEmpty()) {
			return "Your trade List is Empty";
		} else {
			return tradeList;
		}
	}


}
