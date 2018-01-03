package com.zw.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableEurekaClient
@EnableCircuitBreaker
public class TestInvokerServierController {

	@Autowired
	private ProviderService providerService;
	
	@RequestMapping(value="/route",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public Provider router(){
		return  providerService.getProvider(1);
	}
}
