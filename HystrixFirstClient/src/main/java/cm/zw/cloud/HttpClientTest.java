package cm.zw.cloud;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientTest {
	public static void main(String[] args) throws ClientProtocolException, IOException {
		String requestUrl = "http://localhost:8080/normalHello";
		HttpGet request = new HttpGet(requestUrl);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpResponse response = httpClient.execute(request);
		System.out.println(EntityUtils.toString(response.getEntity()));
	}
}
