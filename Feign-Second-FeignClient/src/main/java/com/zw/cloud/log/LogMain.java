package com.zw.cloud.log;

import com.zw.cloud.HelloClient;

import feign.Feign;
import feign.Logger;

public class LogMain {
	/**
	 * @Description 
	 * NONE 默认值 不记录日志
	 * BASIC 记录请求方法URL 响应状态代码 和响应时间
	 * HEADERS 除BASIC以外 还记录请求头和响应头
	 * FULL 在HEADERS 的基础上 请求和响应的元数据都回保存
	 * @param args
	 * @author 
	 * @date 2017年12月20日  下午3:18:26
	 */
	public static void main(String[] args) {
		HelloClient client = Feign.builder()
				.logLevel(Logger.Level.FULL)
				.logger(new Logger.JavaLogger().appendToFile("logs/http.log"))
				.target(HelloClient.class, "http://localhost:8080");
		String result = client.hello();
		System.out.println(result);
	}
}
