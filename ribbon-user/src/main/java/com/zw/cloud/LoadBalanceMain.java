package com.zw.cloud;

import java.util.ArrayList;
import java.util.List;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class LoadBalanceMain {

	public static void main(String[] args) {
		ILoadBalancer lb = new BaseLoadBalancer();
		List<Server> serverList = new ArrayList<Server>();
		serverList.add(new Server("localhost", 8080));
		serverList.add(new Server("localhost", 8081));
		lb.addServers(serverList);
		for(int i = 0;i < 10;i++){
			Server s = lb.chooseServer(null);
			System.out.println(s);
		}
	}
}
