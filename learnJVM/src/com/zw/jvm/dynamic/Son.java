package com.zw.jvm.dynamic;

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

public class Son extends Father{
	void thinking(){
//		super.thinking();
		MethodType mt = MethodType.methodType(void.class);
		MethodHandle mh;
		try {
			mh = lookup().findSpecial(GrandFather.class,"thinking",mt,getClass());
			mh.invoke(this);
		} catch (Throwable e) {
		}
	}
	public static void main(String[] args) {
		Son son = new Son();
		son.thinking();
	}
}
