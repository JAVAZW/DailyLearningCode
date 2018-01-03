package com.zw.eureka.contract;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;

@Configuration
public class MyConfig {

	@Bean
	public Contract getMyContract(){
		return new MyContract();
	}
}
