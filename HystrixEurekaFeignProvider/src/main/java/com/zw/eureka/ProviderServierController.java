package com.zw.eureka;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderServierController {
	
	@RequestMapping(value = "/provide/{id}",method= RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Provider provideService(@PathVariable Integer id){
		Provider provider = new Provider();
		provider.setId(id);
		provider.setName("zw");
		provider.setTel("18612059118");
		return provider;
	}
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(){
		return "hello";
	}
	
	@RequestMapping(value="/tohello",method=RequestMethod.GET)
	public String toHello() throws InterruptedException{
		Thread.sleep(1000);
		return "time out hello";
	}
}
