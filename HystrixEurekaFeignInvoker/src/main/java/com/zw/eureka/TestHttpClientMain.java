package com.zw.eureka;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestHttpClientMain {
	public static void main(String[] args) throws Exception {
		final CloseableHttpClient chc = HttpClients.createDefault();
		for(int i =0;i<6;i++){
			Thread t = new Thread(){
				@Override
				public void run() {
					HttpGet httpGet = new HttpGet("http://127.0.0.1:8081/tohello");
					HttpResponse response;
					try {
						response = chc.execute(httpGet);
						System.out.println(EntityUtils.toString(response.getEntity()));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			t.start();
		}
		Thread.sleep(15000);
	}
}
