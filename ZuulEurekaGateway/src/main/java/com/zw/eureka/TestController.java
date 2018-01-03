package com.zw.eureka;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@RequestMapping(value = "/hhh/hello/{name}",method= RequestMethod.GET)
	public String testForward(@PathVariable("name") String name){
		return "hello forward" +name;
	}
}
