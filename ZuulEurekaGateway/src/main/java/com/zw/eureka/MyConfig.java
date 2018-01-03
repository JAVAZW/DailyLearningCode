package com.zw.eureka;

import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

	@Bean
	public PatternServiceRouteMapper patternServiceRouteMapper(){
		return new PatternServiceRouteMapper("(ZuulEurekaInvoker.+)","${module}/**");
	}
}
