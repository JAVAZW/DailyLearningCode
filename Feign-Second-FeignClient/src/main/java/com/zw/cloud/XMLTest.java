package com.zw.cloud;

import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import feign.jaxb.JAXBEncoder;

public class XMLTest {
	public static void main(String[] args) {
		JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder().build();
		HelloClient client = Feign.builder().encoder(new JAXBEncoder(jaxbFactory)).
				decoder(new JAXBDecoder(jaxbFactory)).target(HelloClient.class, "http://localhost:8080/");
		Person p = new Person();
		p.setId(1);
		p.setMessage("zw");
		p.setName("zw");
		p.setSex("F");
		Result result = client.createXMLPerson(p);
		System.out.println(result.getMessage());
		
	}
}
