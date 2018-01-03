package com.zw.cloud.contract;

public interface ContractClient {

	@MyUrl(url="/hello",method="GET")
	public String hello();
}
