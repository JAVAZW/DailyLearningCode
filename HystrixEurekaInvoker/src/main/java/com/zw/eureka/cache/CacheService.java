package com.zw.eureka.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.zw.eureka.Provider;

@Service
public class CacheService {

	@Autowired
	private RestTemplate restTpl;
	
	@CacheResult
	@HystrixCommand()
	public Provider cacheProvider(Integer id){
		System.out.println("缓存测试");
//		return restTpl.getForObject("http://HystrixEurekaProvider/provide/{id}",
//				Provider.class, id);
		return null;
	}
	
	@CacheResult
	@HystrixCommand(commandKey="cacheKey")
	public String getCache(Integer id){
		System.out.println("执行查询方法");
		return null;
	}
	
	@CacheRemove(commandKey="cacheKey")
	@HystrixCommand
	public void removeCache(Integer id){
		System.out.println("删除缓存方法");
	}
}
