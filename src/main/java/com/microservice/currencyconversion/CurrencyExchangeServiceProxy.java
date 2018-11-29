package com.microservice.currencyconversion;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//Declares that this is a Feign Client and the url at which forex-service is present is 
//@FeignClient(name="forex-service", url= "localhost:8000")	
@FeignClient(name = "forex-service")
@RibbonClient(name="forex-service")
public interface CurrencyExchangeServiceProxy {
	
	//URI of the service we would want to consume
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);

}
