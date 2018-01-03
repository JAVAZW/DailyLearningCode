package com.zw.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServerApp {
	public static void main(String[] args) {
		new SpringApplication(ServerApp.class).run(args);
	}
}
