package com.zw.cloud;

import java.util.ArrayList;
import java.util.List;

import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

public class TestMyRule {

	public static void main(String[] args) {
		BaseLoadBalancer lb = new BaseLoadBalancer();
		List<Server> serverList = new ArrayList<Server>();
		serverList.add(new Server("localhost", 8080));
		serverList.add(new Server("localhost", 8081));
		MyRule rule =new MyRule();
		rule.setLoadBalancer(lb);
		lb.setRule(rule);
		lb.addServers(serverList);
		for(int i = 0;i < 10;i++){
			Server s = lb.chooseServer(null);
			System.out.println(s);
		}
	}
}
