package com.zw.eureka;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zw.eureka.contract.MyUrl;

@FeignClient("FeignEurekaProvider")
public interface HelloClient {

	@RequestMapping(method=RequestMethod.GET,value="/hello/{name}")
	String hello(@PathVariable("name") String name);
	
	@RequestMapping(method=RequestMethod.GET,value="/provide/{id}")
	Provider getProvider(@PathVariable("id")Integer id);
	
	@MyUrl(method="GET",url="/hellowithoutparam")
	String getHelloWithoutParam();
}
