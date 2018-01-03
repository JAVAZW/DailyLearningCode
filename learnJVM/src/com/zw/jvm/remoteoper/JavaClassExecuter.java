package com.zw.jvm.remoteoper;

import java.lang.reflect.Method;

/**
 * @Description ִ�й���
 * 
 * @author 
 * @date 2017��9��5��  ����8:13:11
 * Company: zw
 */
public class JavaClassExecuter {

	/**
	 * @Description 
	 * ִ���ⲿ�������Ĵ���һ��Java���byte����<br>
	 * ���������byte�����д���java.lang.System�� CONSTANT_Utf8_info�����ٳֺ��HackSystem��
	 * ִ�з���Ϊ�����static main(String[]args)������������Ϊ������System.out/err�������Ϣ
	 * @param classByte
	 * @return
	 * @author 
	 * @date 2017��9��5��  ����8:16:43
	 */
	public static String execute(byte[] classByte){
		HackSystem.clearBuffer();
		ClassModifier cm = new ClassModifier(classByte);
		byte[] modiBytes = cm.modifyUTF8Constant("java/lang/System","com/zw/jvm/remoteoper/HackSystem");
		HotSwapClassLoader loader = new HotSwapClassLoader();
		Class clazz = loader.loadByte(classByte);
		try{
			Method method = clazz.getMethod("main", new Class[]{String[].class});
			method.invoke(null, new String[]{null});
		}catch(Throwable e){
			e.printStackTrace(HackSystem.out);
		}
		return HackSystem.getBufferString();
	}
}
