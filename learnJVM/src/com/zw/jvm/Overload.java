package com.zw.jvm;

/**
 * @Description ��̬��������λ����ִ�а汾�ķ��ɶ�����Ϊ��̬���䡣
 * 				���ط���ƥ�����ȼ�
 * @author 
 * @date 2017��8��30��  ����4:16:00
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
