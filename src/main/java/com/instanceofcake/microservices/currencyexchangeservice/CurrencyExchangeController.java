package com.instanceofcake.microservices.currencyexchangeservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	Logger logging = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Environment env;
	
	@Autowired
    ExchangeValueRepository repo;
	
	@GetMapping("currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		 ExchangeValue exchangeValue = repo.findByFromCurrencyAndToCurrency(from, to);
		 
		 logging.info("{}",exchangeValue);
		 
		 exchangeValue.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		 return exchangeValue;
		
	}

}
