package com.zw.org;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class FirstSpringBoot {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String port = sc.nextLine();
		new SpringApplicationBuilder(FirstSpringBoot.class).properties("server.port="+port).web(true).run(args);
//	   SpringApplication.run(FirstSpringBoot.class, args);
	 }

}
