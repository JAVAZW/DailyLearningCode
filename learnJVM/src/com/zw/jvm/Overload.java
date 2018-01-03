package com.zw.jvm;

/**
 * @Description 静态类型来定位方法执行版本的分派动作称为静态分配。
 * 				重载方法匹配优先级
 * @author 
 * @date 2017年8月30日  下午4:16:00
 * Company: zw
 */
public class Overload {

	public static void sayHello(Object arg){
		System.out.println("hello object");
	}
	
	public static void sayHello(int arg){
		System.out.println("hello int");
	}
	
	public static void sayHello(long arg){
		System.out.println("hello long");
	}
	
	public static void sayHello(Character arg){
		System.out.println("hello Character");
	}
	
//	public static void sayHello(char arg){
//		System.out.println("hello char");
//	}
	
	public static void sayHello(char ...arg){
		System.out.println("hello char...");
	}
	
	public static void main(String[] args) {
		sayHello('a');
	}
}
