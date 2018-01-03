package com.zw.eureka.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="HystrixEurekaFeignProvider",fallback=HelloClientFallBack.class)
public interface HelloClient {

	@RequestMapping(method=RequestMethod.GET,value="/hello")
	public String hello();
	
	@RequestMapping(method=RequestMethod.GET,value="/tohello")
	public String tohello();
}
