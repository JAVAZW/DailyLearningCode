package com.zw.eureka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.SpringClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.spel.CodeFlow.ClinitAdder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;

@RestController
@Configuration
public class TestInvokerServierController {

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
	
	@GetMapping("/route")
	@ResponseBody
	public String router(){
		RestTemplate rtl = getRestTemplate();
		String result = rtl.getForObject("http://RibbonEurekaProvider/provide/1", String.class);
		return  result;
	}
	
	/**
	 * @Fields client 
	 * @author 
	 * @date 2017年12月14日  下午4:37:58
	 * @Description
	 * Spring 分装好的负载均衡器 客户端
	 */
	@Autowired
	private LoadBalancerClient client;
	
	/**
	 * @Description loadbalancerclient会帮我选择一个服务实例
	 * @return
	 * @author 
	 * @date 2017年12月14日  下午4:46:00
	 */
	@RequestMapping(value="/lb",method=RequestMethod.GET,produces= MediaType.APPLICATION_JSON_VALUE)
	public ServiceInstance lb(){
		//选择一个服务实例
		return client.choose("RibbonEurekaProvider");
	}
	
	@Autowired
	private SpringClientFactory factory;
	
	@RequestMapping(value="/fa",method=RequestMethod.GET)
	public String factory(){
		ZoneAwareLoadBalancer zlb = (ZoneAwareLoadBalancer) factory.getLoadBalancer("defalut");
		System.out.println(zlb.getRule().getClass().getName());
		
		ILoadBalancer myzlb =  factory.getLoadBalancer("RibbonEurekaProvider");
		System.out.println(myzlb.getClass().getName());
		if(myzlb instanceof ZoneAwareLoadBalancer){
			ZoneAwareLoadBalancer zlbTest = (ZoneAwareLoadBalancer)myzlb;
			System.out.println(zlbTest.getRule().getClass().getName());
		}
		return "";
	}
}
