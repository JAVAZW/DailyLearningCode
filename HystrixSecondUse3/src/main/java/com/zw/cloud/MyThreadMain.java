package com.zw.cloud;

import com.netflix.config.ConfigurationManager;

public class MyThreadMain {

	public static void main(String[] args) throws InterruptedException {
		ConfigurationManager.getConfigInstance().addProperty("hystrix.threadpool.default.coreSize",3);
		for(int i = 0;i < 6; i++){
			MyCommand myCommand = new MyCommand(i);
			myCommand.queue();
		}
		Thread.sleep(5000);
	}
}
