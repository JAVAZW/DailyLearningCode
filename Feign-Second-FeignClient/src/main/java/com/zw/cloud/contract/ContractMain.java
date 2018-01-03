package com.zw.cloud.contract;

import feign.Feign;

public class ContractMain {

	public static void main(String[] args) {
		ContractClient client = Feign.builder()
				.contract(new MyContract())
				.target(ContractClient.class, "http://localhost:8080/");
		String result = client.hello();
		System.out.println(result);
	}
}
