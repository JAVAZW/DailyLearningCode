package com.zw.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Configuration
public class TestInvokerServierController {

//	@Bean
//	@LoadBalanced
//	public RestTemplate getRestTemplate(){
//		return new RestTemplate();
//	}
//	
//	@GetMapping("/route")
//	@ResponseBody
//	public String router(){
//		RestTemplate rtl = getRestTemplate();
//		String result = rtl.getForObject("http://EUREKAPROVIDER/provide/1", String.class);
//		return  result;
//	}
	
	@Autowired
	private HelloClient helloClient;
	
	@RequestMapping(method=RequestMethod.GET,value="/router")
	public String router(){
		String result = helloClient.hello("zw");
		return result;
	}
	
	@RequestMapping(method=RequestMethod.GET,value= "/provider")
	public Provider provider(){
		return helloClient.getProvider(1);
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value= "/myhello")
	public String myHello(){
		return helloClient.getHelloWithoutParam();
	}
}
