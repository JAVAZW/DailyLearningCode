package com.zw.org;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

	@RequestMapping(value="/person/{id}",method=RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Person getPersonById(@PathVariable Integer id,HttpServletRequest request){
		Person person = new Person();
		person.setId(id);
		person.setName("zw");
		person.setSex("f");
		person.setMessage(request.getRequestURL().toString());
		return person;
	}
	
	/**
	 * @Description 测试feign的案例
	 * @param p
	 * @return
	 * @author 
	 * @date 2017年12月19日  上午9:33:39
	 */
	@RequestMapping(value="/person/create",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE)
	public String createPerson(@RequestBody Person p){
		System.out.println(p.getName()+"---"+p.getSex());
		return "success:id"+p.getId();
	}
	
	@RequestMapping(value="/person/createXML",method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_XML_VALUE,
			produces=MediaType.APPLICATION_XML_VALUE)
	public String createPersonXML(@RequestBody Person p){
		System.out.println(p.getName()+"---"+p.getSex());
		return "<result><message>success</message></result>";
		
	}
}
