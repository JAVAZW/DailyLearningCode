package com.zw.eureka;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ZuulEurekaProvider")
public interface ProviderClient {
	
	@RequestMapping(value="/provider/{id}",method=RequestMethod.GET)
	public Provider getProvider(@PathVariable("id")Integer id);
	
}
