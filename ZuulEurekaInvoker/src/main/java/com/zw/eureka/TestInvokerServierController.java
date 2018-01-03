package com.zw.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class TestInvokerServierController {

	@Autowired
	private ProviderClient providerClient;

	
	@RequestMapping(value="/invoker/{providerId}",method=RequestMethod.GET)
	public String queryProvider(@PathVariable Integer providerId){
		Provider provider = providerClient.getProvider(providerId);
		System.out.println(provider.getId()+"______"+provider.getName());
		return "success";
	}
}
