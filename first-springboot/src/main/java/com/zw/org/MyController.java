package com.zw.org;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

	@GetMapping("/hello")
	@ResponseBody
	public String home(){
		return "Hello World";
	}
}
