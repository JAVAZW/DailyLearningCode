package com.zw.cloud.config;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class PropertyMain {
	public static void main(String[] args) {
		ConfigurationManager
		.getConfigInstance()
		.setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", 1000);
		PropertyCommand c = new PropertyCommand();
		String result = c.execute();
		System.out.println(result);
	}

	static class PropertyCommand extends HystrixCommand<String>{
		public PropertyCommand(){
			super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestGroup")));
		}

		@Override
		protected String run() throws Exception {
			Thread.sleep(2000);
			return "success";
		}
		
		@Override
		protected String getFallback() {
			return "fallback";
		}
		
	}
}
