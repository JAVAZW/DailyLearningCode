package com.zw.cloud.cb;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class FallBackMain {

	public static void main(String[] args) {
		FallbackCommand command = new FallbackCommand();
		String result = command.execute();
		System.out.println(result);
	}
	
	static class FallbackCommand extends HystrixCommand<String>{

		public FallbackCommand() {
			super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestGroupKey"))
					.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
							.withCircuitBreakerForceOpen(true)));
		}
		
		@Override
		protected String run() throws Exception {
			return "success";
		}
	
		@Override
		protected String getFallback() {
			return "fallback";
		}
	}
}
