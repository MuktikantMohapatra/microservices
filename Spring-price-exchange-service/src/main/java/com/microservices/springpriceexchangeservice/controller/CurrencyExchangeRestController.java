package com.microservices.springpriceexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.springpriceexchangeservice.beans.ExchangeValue;

@RestController
public class CurrencyExchangeRestController {
	@Autowired
	private Environment envirolent;

	@GetMapping("/currency-exchange-service/from/{from}/to/{to}")
	public ExchangeValue retriveExchangeValue(@PathVariable String from, @PathVariable String to) {
		ExchangeValue exchangeValue = new ExchangeValue(100L, from, to, BigDecimal.valueOf(65L));
		exchangeValue.setPort(Integer.parseInt(envirolent.getProperty("local.server.port")));
		System.out.println("CurrencyExchangeRestController.retriveExchangeValue()");
		return exchangeValue;
	}
}
