package com.zw.eureka;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurakeServerController {

	public static void main(String[] args) {
		new SpringApplicationBuilder(EurakeServerController.class).web(true).run(args);
	}
}
