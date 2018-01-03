package com.zw.cloud;

import java.net.URI;


import com.netflix.client.ClientFactory;
import com.netflix.client.http.HttpRequest;
import com.netflix.client.http.HttpResponse;
import com.netflix.config.ConfigurationManager;
import com.netflix.loadbalancer.ZoneAwareLoadBalancer;
import com.netflix.niws.client.http.RestClient;

public class TestRibbon {

	public static void main(String[] args) throws Exception{
//      ConfigurationManager.loadPropertiesFromResources("my-ribbon.properties");  // 1
//      System.out.println(ConfigurationManager.getConfigInstance().getProperty("sample-client.ribbon.listOfServers"));
		 ConfigurationManager.getConfigInstance().setProperty(
		      		"simple-client.ribbon.listOfServers", "localhost:8080, localhost:8081"); // 5
		 
		 RestClient client = (RestClient)ClientFactory.getNamedClient("sample-client");
		 HttpRequest request = HttpRequest.newBuilder().uri("/person/1").build();
		 
		 for(int i =0;i<6;i++){
			 HttpResponse response = client.executeWithLoadBalancer(request);
			 String result = response.getEntity(String.class);
			 System.out.println(result);
		 }
	}
	
}
