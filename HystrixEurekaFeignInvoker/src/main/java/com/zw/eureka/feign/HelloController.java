package com.zw.eureka.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.HystrixCircuitBreaker;
import com.netflix.hystrix.HystrixCommandKey;

@RestController
public class HelloController {

	
	@Autowired
	private HelloClient helloClient;
	
	@RequestMapping(method=RequestMethod.GET,value="/hello")
	public String hello(){
		return helloClient.hello();
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/tohello")
	public String tohello(){
		String result = helloClient.tohello();
		HystrixCircuitBreaker breaker = HystrixCircuitBreaker.Factory.getInstance(HystrixCommandKey.Factory.asKey("HelloClient#tohello()"));
		System.out.println("断路器状态#############"+breaker.isOpen());
		return result;
	}
}
