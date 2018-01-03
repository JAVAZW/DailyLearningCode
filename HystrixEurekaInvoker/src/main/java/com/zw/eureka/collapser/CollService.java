package com.zw.eureka.collapser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.zw.eureka.Provider;

@Service
public class CollService {

	@HystrixCollapser(batchMethod="getProvider",collapserProperties={
			@HystrixProperty(name="timerDelayInMilliseconds",value="1000")
	})
	public Future<Provider> getProviders(Integer id){
		System.out.println("执行单个查询的方法");
		return null;
	}
	
	@HystrixCommand
	public List<Provider> getProvider(List<Integer> ids){
		List<Provider> list = new ArrayList<Provider>();
		for(Integer id : ids){
			System.out.println(id);
			Provider p= new Provider();
			p.setId(id);
			p.setName("zw"+id);
			list.add(p);
		}
		return list;
	}
}
