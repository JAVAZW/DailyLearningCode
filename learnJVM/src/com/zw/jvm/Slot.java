package com.zw.jvm;

/**
 * @Description  局部变量表中的slot是可以重用的
 * @author 
 * @date 2017年8月29日  下午7:58:38
 * Company: zw
 */
public class Slot {

	public static void main(String[] args) throws InterruptedException {
		{
			byte[] placeholder = new byte[1];
		}
		int i = 0;
		System.gc();
	}
}
