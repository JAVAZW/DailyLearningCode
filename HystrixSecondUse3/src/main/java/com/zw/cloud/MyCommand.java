package com.zw.cloud;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class MyCommand extends HystrixCommand<String>{

	private Integer index;
	
	
	protected MyCommand(Integer index) {
		super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestGroupKey")));
		this.index=index;
	}

	@Override
	protected String run() throws Exception {
		Thread.sleep(800);
		System.out.println("执行run方法"+index);
		return "success";
	}
	
	@Override
	protected String getFallback() {
		System.out.println("执行回调方法"+index);
		return "fall back";
	}

	
}
