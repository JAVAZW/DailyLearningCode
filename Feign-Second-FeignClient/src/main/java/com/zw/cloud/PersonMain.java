package com.zw.cloud;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * @Description 
 * @author 
 * @date 2017年12月18日  下午10:20:34
 * Company: zw
 */
public class PersonMain {
	public static void main(String[] args) {
		HelloClient client = Feign.builder().decoder(new GsonDecoder()).target(HelloClient.class,"http://127.0.0.1:8080");
		Person p = client.getPerson(1);
		System.out.println(p.getId());
		System.out.println(p.getName());
		System.out.println(p.getSex());
		System.out.println(p.getMessage());
	}
}
