package com.zw.jvm;

/**
 * @Description  �ֲ��������е�slot�ǿ������õ�
 * @author 
 * @date 2017��8��29��  ����7:58:38
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
