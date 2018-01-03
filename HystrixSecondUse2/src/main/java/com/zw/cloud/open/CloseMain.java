package com.zw.cloud.open;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandMetrics.HealthCounts;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommand.Setter;

public class CloseMain {
	
	public static void main(String[] args) throws Exception {
		//10s内有10次请求
		ConfigurationManager.getConfigInstance()
		.setProperty("hystrix.command.default.circuitBreaker.requestVolumeThreshold", 3);
		boolean isTimeout = true;
		for(int i= 0 ;i<10;i++){
			TestCommand c= new TestCommand(isTimeout);
			c.execute();
			HealthCounts hc = c.getMetrics().getHealthCounts();
			System.out.println("断路器状态："+c.isCircuitBreakerOpen()+"；请求数量："+hc.getTotalRequests());
			if(c.isCircuitBreakerOpen()){
				isTimeout =false;
				System.out.println("**********************断路器打开，等待休眠期结束");
				Thread.sleep(6000);
				
			}
		}
	}
	
	static class TestCommand extends HystrixCommand<String>{
		private boolean isTimeOut;
		public TestCommand(boolean isTimeOut) {
			super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
					.andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(500)));
			this.isTimeOut=isTimeOut;
		}
		
		@Override
		protected String run() throws Exception {
			if(isTimeOut){
				Thread.sleep(800);
			}else{
				Thread.sleep(200);
			}
			return "success";
		}
		
		@Override
		protected String getFallback() {
			return "fallback";
		}
	}
	
}
