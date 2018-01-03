package com.zw.eureka.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyFilterConfig {

	@Bean
	public MyFilter myFilter(){
		return new MyFilter();
	}
}
