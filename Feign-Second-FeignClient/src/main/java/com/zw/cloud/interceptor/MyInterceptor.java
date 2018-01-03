package com.zw.cloud.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;

public class MyInterceptor implements RequestInterceptor{

	public void apply(RequestTemplate requestTemplate) {
		requestTemplate.header("Content-Type", "application/json");
		System.out.println("’‚ ««Î«Û¿πΩÿ∆˜");
	}

}
