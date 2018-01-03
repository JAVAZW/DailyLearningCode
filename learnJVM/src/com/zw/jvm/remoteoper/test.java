package com.zw.jvm.remoteoper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class test {
	public static void main(String[] args) throws IOException {
		InputStream is = new FileInputStream("E:\\TestClass.class");
		byte[] b = new byte[is.available()];
		is.read(b);
		is.close();
		JavaClassExecuter.execute(b);
	}
}
