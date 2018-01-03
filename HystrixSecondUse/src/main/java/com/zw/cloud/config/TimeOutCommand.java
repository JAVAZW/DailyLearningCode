package com.zw.cloud.config;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class TimeOutCommand extends HystrixCommand<String>{

	public TimeOutCommand() {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestGroup"))
				.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
						.withExecutionTimeoutInMilliseconds(2000)));
	}

	@Override
	protected String run() throws Exception {
		Thread.sleep(3000);
		System.out.println("ִ������");
		return "success";
	}

	@Override
	protected String getFallback() {
		System.out.println("ִ�лص�����");
		return "fail back";
	}
	
}
