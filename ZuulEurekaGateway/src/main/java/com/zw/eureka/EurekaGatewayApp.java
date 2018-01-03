package com.zw.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class EurekaGatewayApp {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaGatewayApp.class).web(true).run(args);
	}
	
}
