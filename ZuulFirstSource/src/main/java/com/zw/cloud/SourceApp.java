package com.zw.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SourceApp {

	public static void main(String[] args) {
		new SpringApplication(SourceApp.class).run(args);
	}
}
