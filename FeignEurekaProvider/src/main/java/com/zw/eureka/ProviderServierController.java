package com.zw.eureka;

import javax.servlet.http.HttpServletRequest;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderServierController {
	
	@RequestMapping(value = "/provide/{id}",method= RequestMethod.GET,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public Provider provideService(@PathVariable Integer id,HttpServletRequest request){
		Provider provider = new Provider();
		provider.setId(id);
		provider.setName("zw");
		provider.setTel("18612059118");
		provider.setMessage(request.getRequestURL().toString());
		return provider;
	}
	
	@RequestMapping(value = "/hello/{name}",method= RequestMethod.GET)
	public String hello(@PathVariable String name){
		return "Hello"+name;
	}
	
	@RequestMapping(value = "/hellowithoutparam",method= RequestMethod.GET)
	public String helloWithOutParam(){
		return "Hello,world";
	}
}
