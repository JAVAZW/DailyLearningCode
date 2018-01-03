package com.zw.eureka.contract;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

import feign.MethodMetadata;

public class MyContract extends SpringMvcContract{

	@Override
	protected void processAnnotationOnMethod(MethodMetadata data,
			Annotation annotation, Method method) {
		super.processAnnotationOnMethod(data, annotation, method);
		if(MyUrl.class.isInstance(annotation)){
			System.out.println("#######自定义contract");
			MyUrl myUrl = method.getAnnotation(MyUrl.class);
			String url = myUrl.url();
			String httpMethod = myUrl.method();
			data.template().method(httpMethod);
			data.template().append(url);
		}
	}

}
