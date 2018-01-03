package com.zw.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class RouterApp {

	public static void main(String[] args) {
		new SpringApplication(RouterApp.class).run(args);
	}
}
