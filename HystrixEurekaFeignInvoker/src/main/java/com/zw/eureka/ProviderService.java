package com.zw.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;

@Service
//@DefaultProperties(defaultFallback="getFallBackProvider")
public class ProviderService {

	@Autowired
	private RestTemplate restTpl;

	@HystrixCommand(fallbackMethod = "getFallBackProvider",commandProperties={@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1000")},threadPoolProperties={
			@HystrixProperty(name = "coreSize",value="2")})
	public Provider getProvider(Integer id) {
		return restTpl
				.getForObject("http://HystrixEurekaProvider/provide/{id}",
						Provider.class, id);
	}

	public Provider getFallBackProvider(Integer id) {
		Provider provider = new Provider();
		provider.setId(id);
		provider.setName("fall back");
		return provider;
	}
	
}
