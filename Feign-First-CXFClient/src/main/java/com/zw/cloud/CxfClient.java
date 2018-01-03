package com.zw.cloud;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

/**
 * @Description 学习feign之前看下cxf的调用 
 * @author 
 * @date 2017年12月18日  下午8:29:13
 * Company: zw
 */
public class CxfClient {
	
	public static void main(String[] args) throws IOException {
		WebClient wclient = WebClient.create("http://localhost:8080/person/1");
		Response response = wclient.get();
		InputStream is = (InputStream)response.getEntity();
		String content = IOUtils.readStringFromStream(is);
		System.out.println(content);
	}
}
