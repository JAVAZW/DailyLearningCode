package com.zw.jvm;

import java.io.IOException;
import java.io.InputStream;


/**
 * 比较两个类是否“相等”只有在这两个类是由同一个类加载器的前提下才有意义
 * 否则即使这两个类来源于同一个class文件，被同一个虚拟机加载，只要加载他们的类加载器不同，那这两个类就必定不相等。
 * 
 * @Description  不同的类加载器 对instanceof关键字运算的结果的影响
 * @author zw
 * @date 2017年8月25日  下午5:17:52
 * Company: zw
 */
public class ClassLoaderTest {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		ClassLoader myLoader = new ClassLoader() {
			public Class<?> loadClass(String name)throws ClassNotFoundException{
				try {
					String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if(null == is){
						return super.loadClass(name);
					}			
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(name,b,0,b.length);
				} catch (IOException e) {
					throw new ClassNotFoundException(name);
				}
			}
		};
		Object obj = myLoader.loadClass("com.zw.jvm.ClassLoaderTest").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.zw.jvm.ClassLoaderTest);
	}
	
}
