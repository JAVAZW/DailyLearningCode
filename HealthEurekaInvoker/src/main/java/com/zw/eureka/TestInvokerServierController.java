package com.zw.eureka;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class TestInvokerServierController {

	@Autowired
	private DiscoveryClient discoveryClient;
	
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	@GetMapping("/route")
	@ResponseBody
	public String router(){
		RestTemplate rtl = getRestTemplate();
		String result = rtl.getForObject("http://EUREKAPROVIDER/provide/1", String.class);
		return  result;
	}
	
	@GetMapping("/list")
	@ResponseBody
	public String serviceCount(){
		List<String> listService = discoveryClient.getServices();
		for(String serviceId:listService){
			List<ServiceInstance> instance = discoveryClient.getInstances(serviceId);
			System.out.println(serviceId +" :" +instance.size());
		}
		return "";
	} 
}
