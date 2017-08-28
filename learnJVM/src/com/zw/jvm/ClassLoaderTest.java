package com.zw.jvm;

import java.io.IOException;
import java.io.InputStream;


/**
 * �Ƚ��������Ƿ���ȡ�ֻ����������������ͬһ�����������ǰ���²�������
 * ����ʹ����������Դ��ͬһ��class�ļ�����ͬһ����������أ�ֻҪ�������ǵ����������ͬ������������ͱض�����ȡ�
 * 
 * @Description  ��ͬ��������� ��instanceof�ؼ�������Ľ����Ӱ��
 * @author zw
 * @date 2017��8��25��  ����5:17:52
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
