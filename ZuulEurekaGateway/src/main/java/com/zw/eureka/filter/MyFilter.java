package com.zw.eureka.filter;


import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;

public class MyFilter extends ZuulFilter{

	@Override
	public Object run() {
		System.out.println("执行MyFilter 过滤器");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return FilterConstants.ROUTE_TYPE;
	}

}
