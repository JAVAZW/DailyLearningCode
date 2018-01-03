package com.zw.cloud;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableHystrixDashboard
public class DashBoardMain {

	public static void main(String[] args) {
		new SpringApplicationBuilder(DashBoardMain.class).properties("server.port=8082").run(args);
	}
}
