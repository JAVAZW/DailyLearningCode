package com.zw.cloud;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;

public class MySemaphoreMain {

	public static void main(String[] args) throws InterruptedException {
		ConfigurationManager.getConfigInstance()
		.addProperty("hystrix.command.default.execution.isolation.strategy", ExecutionIsolationStrategy.SEMAPHORE);
		
		ConfigurationManager.getConfigInstance()
		.addProperty("hystrix.command.default.execution.isolation.semaphore.maxConcurrentRequests",4);
		
		for(int i= 0 ;i< 6;i++){
			final Integer index = i;
			Thread thread = new Thread(){
				@Override
				public void run() {
					MyCommand command = new MyCommand(index);
					command.execute();
				}
			};
			thread.start();
		}
		
		Thread.sleep(6000);
	}
}
