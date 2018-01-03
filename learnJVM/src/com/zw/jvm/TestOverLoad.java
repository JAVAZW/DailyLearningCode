package com.zw.jvm;

import java.util.List;

public class TestOverLoad {

	public void getA(int a){
		
	}
	
	public void getA(String a ){
		
	}
	
//	public static String method(List<String>list){
//		return"";
//	}
//	public static int method(List<Integer>list){
//		return 1;
//	}
	public static void main(String[] args) {
		Integer a=1;
		Integer b=2;
		Integer c=3;
		Integer d=3;
		Integer e=321;
		Integer f=321;
		Long g=3L;
		
		System.out.println(c==d);//true
		System.out.println(e==f);//false
		System.out.println(e.equals(f));//true
		System.out.println(c==(a+b));//true
		System.out.println(c.equals(a+b));// true
		System.out.println(g==(a+b));//true
		System.out.println(g.equals(a+b));//false
		
//		while(false){
//			System.out.println("ss");
//		}
	}
}
