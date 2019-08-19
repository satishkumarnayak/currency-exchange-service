package com.instanceofcake.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository  extends JpaRepository<ExchangeValue, Long>{
	
	public ExchangeValue findByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);

}
