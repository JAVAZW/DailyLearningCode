package com.zw.eureka;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
public class MyHealthIndicate implements HealthIndicator{

	@Override
	public Health health() {
		if(ProviderServierController.canVisitDB){
			return new Health.Builder(Status.UP).build();
		}else{
			return new Health.Builder(Status.DOWN).build();
		}
	}
}
