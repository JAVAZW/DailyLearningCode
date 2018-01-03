package com.zw.cloud;

import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ServiceApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String port = sc.nextLine();
		new SpringApplicationBuilder(ServiceApp.class).properties(
				"server.port=" + port).run(args);
	}
}
