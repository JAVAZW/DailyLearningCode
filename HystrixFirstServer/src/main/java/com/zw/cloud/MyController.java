package com.zw.cloud;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	@RequestMapping(value="/normalHello",method=RequestMethod.GET)
	public String normalHello(){
		return "hello world";
	}
	
	@RequestMapping(value="/errorHello",method=RequestMethod.GET)
	public String errorHello(){
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "error hello";
	}
}
