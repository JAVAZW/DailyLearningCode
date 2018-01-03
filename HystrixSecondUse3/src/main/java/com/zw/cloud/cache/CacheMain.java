package com.zw.cloud.cache;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.HystrixRequestCache;
import com.netflix.hystrix.strategy.concurrency.HystrixConcurrencyStrategyDefault;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;

public class CacheMain {
	public static void main(String[] args) {
		HystrixRequestContext ctx = HystrixRequestContext.initializeContext();
		String key = "cache-key";
		CacheCommand c1 = new CacheCommand(key);
		CacheCommand c2 = new CacheCommand(key);
		CacheCommand c3 = new CacheCommand(key);
		c1.execute();
		c2.execute();
		c3.execute();
		System.out.println("����C1�Ƿ��ȡ����"+c1.isResponseFromCache());
		System.out.println("����C2�Ƿ��ȡ����"+c2.isResponseFromCache());
		System.out.println("����C3�Ƿ��ȡ����"+c3.isResponseFromCache());
		
		HystrixRequestCache cache =HystrixRequestCache.getInstance(HystrixCommandKey.Factory.asKey("MyCommandKey"),
				HystrixConcurrencyStrategyDefault.getInstance());
		cache.clear(key);
		
		CacheCommand c4 = new CacheCommand(key);
		c4.execute();
		System.out.println("����C4�Ƿ��ȡ����"+c4.isResponseFromCache());
		ctx.shutdown();
	}
	
	static class CacheCommand extends HystrixCommand<String>{
		private String cacheKey;
		public CacheCommand(String cacheKey){
			super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("TestGroupKey"))
					.andCommandKey(HystrixCommandKey.Factory.asKey("MyCommandKey")));
			this.cacheKey = cacheKey;
		}
		@Override
		protected String run() throws Exception {
			System.out.println("ִ�з���"+cacheKey);
			return "";
		}
		@Override
		protected String getFallback() {
			System.out.println("ִ�лص�"+cacheKey);
			return super.getFallback();
		}
		@Override
		protected String getCacheKey() {
			return this.cacheKey;
		}
	}
}
