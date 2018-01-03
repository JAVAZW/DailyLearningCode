package com.zw.eureka.cache;

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
public class CacheController {

	@Autowired
	private CacheService cacheService;
	
	@RequestMapping(value="/cache",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String cache(){
		for(int i=0;i<3;i++){
			cacheService.cacheProvider(1);
		}
		return  "123";
	}
	
	@RequestMapping(value="/rc",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String removeCache(){
		for(int i=0;i<2;i++){
			cacheService.getCache(1);
		}
		cacheService.removeCache(1);
		System.out.println("############################");
		cacheService.getCache(1);
		return  "123";
	}
	
}
