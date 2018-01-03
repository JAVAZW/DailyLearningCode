package com.zw.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.HealthCheckHandler;
import com.netflix.appinfo.InstanceInfo.InstanceStatus;

@Component
public class MyHealthCheckHandle implements HealthCheckHandler {

	@Autowired
	private MyHealthIndicate myHealthIndicate;
	
	@Override
	public InstanceStatus getStatus(InstanceStatus arg0) {
		Status status = myHealthIndicate.health().getStatus();
		if(status.equals(Status.UP)){
			return InstanceStatus.UP;
		}else{
			return InstanceStatus.DOWN;
		}
	}

}
