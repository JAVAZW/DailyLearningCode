package com.zw.eureka;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaProviderController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String port = sc.nextLine();
		new SpringApplicationBuilder(EurekaProviderController.class).properties("server.port="+port).run(args);
	}
	
}
