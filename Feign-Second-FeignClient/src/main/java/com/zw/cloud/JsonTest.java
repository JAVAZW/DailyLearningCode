package com.zw.cloud;

import feign.Feign;
import feign.gson.GsonEncoder;

public class JsonTest {
	public static void main(String[] args) {
		HelloClient client = Feign.builder().encoder(new GsonEncoder()).
				target(HelloClient.class, "http://localhost:8080");
		Person p = new Person();
		p.setId(1);
		p.setMessage("hello world");
		p.setSex("F");
		p.setName("zw");
		client.create(p);
	}
}
