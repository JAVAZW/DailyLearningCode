package com.zw.cloud.log;

import com.zw.cloud.HelloClient;

import feign.Feign;
import feign.Logger;

public class LogMain {
	/**
	 * @Description 
	 * NONE Ĭ��ֵ ����¼��־
	 * BASIC ��¼���󷽷�URL ��Ӧ״̬���� ����Ӧʱ��
	 * HEADERS ��BASIC���� ����¼����ͷ����Ӧͷ
	 * FULL ��HEADERS �Ļ����� �������Ӧ��Ԫ���ݶ��ر���
	 * @param args
	 * @author 
	 * @date 2017��12��20��  ����3:18:26
	 */
	public static void main(String[] args) {
		HelloClient client = Feign.builder()
				.logLevel(Logger.Level.FULL)
				.logger(new Logger.JavaLogger().appendToFile("logs/http.log"))
				.target(HelloClient.class, "http://localhost:8080");
		String result = client.hello();
		System.out.println(result);
	}
}
