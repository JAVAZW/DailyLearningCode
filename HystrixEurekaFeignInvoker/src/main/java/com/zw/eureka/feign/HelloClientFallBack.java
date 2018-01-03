package com.zw.eureka.feign;

import org.springframework.stereotype.Component;

@Component
public class HelloClientFallBack implements HelloClient {

	@Override
	public String hello() {
		return "fall back hello";
	}

	@Override
	public String tohello() {
		return "fall back time out hello";
	}

}
