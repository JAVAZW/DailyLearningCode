package com.zw.eureka;

import java.util.List;
import java.util.Random;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.Server;

public class MyRule implements IRule{

	private ILoadBalancer lb;
	
	public Server choose(Object key) {
		System.out.println("自定义规则类");
		Random rd = new Random();
		int rNum = rd.nextInt(10);
		System.out.println(rNum);
		List<Server> servers = lb.getAllServers();
		if(rNum > 7){
			return getServerByPort(servers, 8080);
		}
		return getServerByPort(servers, 8081);
	}

	private Server getServerByPort(List<Server> servers,int port){
		for(Server server : servers){
			if(server.getPort() == port){
				return server;
			}
		}
		return null;
	}
	public void setLoadBalancer(ILoadBalancer lb) {
		this.lb = lb;
	}

	public ILoadBalancer getLoadBalancer() {
		return this.lb;
	}

}
