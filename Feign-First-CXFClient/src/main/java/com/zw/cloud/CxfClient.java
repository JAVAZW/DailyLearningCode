package com.zw.cloud;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.apache.cxf.jaxrs.client.WebClient;

/**
 * @Description ѧϰfeign֮ǰ����cxf�ĵ��� 
 * @author 
 * @date 2017��12��18��  ����8:29:13
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
