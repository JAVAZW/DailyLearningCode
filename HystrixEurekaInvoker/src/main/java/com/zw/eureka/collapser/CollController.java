package com.zw.eureka.collapser;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zw.eureka.Provider;

@RestController
public class CollController {

	@Autowired
	private CollService collService;
	
	@RequestMapping(value="/coll",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public String getColl() throws InterruptedException, ExecutionException{
		
		Future<Provider> f1= collService.getProviders(1);
		Future<Provider> f2= collService.getProviders(2);
		Future<Provider> f3= collService.getProviders(3);
		Provider p1 = f1.get();
		Provider p2 = f1.get();
		Provider p3 = f1.get();
		return "";
	}
}
