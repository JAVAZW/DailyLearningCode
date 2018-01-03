package cm.zw.cloud;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class ErrorCommand extends HystrixCommand<String>{

	protected ErrorCommand() {
		super(HystrixCommandGroupKey.Factory.asKey("TestGroup"));
	}
	
	@Override
	protected String run() throws Exception {
		String requestUrl = "http://localhost:8080/errorHello";
		HttpGet request = new HttpGet(requestUrl);
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpResponse response = httpClient.execute(request);
		return EntityUtils.toString(response.getEntity());
	}

	@Override
	protected String getFallback() {
		System.out.println("fall back method");
		return "fall back hello";
	}
	
	
}
