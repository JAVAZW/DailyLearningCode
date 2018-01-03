package com.zw.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderController {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurekaProviderController.class).web(true).run(args);
	}
	
}
