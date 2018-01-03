package com.zw.jvm.remoteoper;

import java.lang.reflect.Method;

/**
 * @Description 执行工具
 * 
 * @author 
 * @date 2017年9月5日  下午8:13:11
 * Company: zw
 */
public class JavaClassExecuter {

	/**
	 * @Description 
	 * 执行外部传过来的代表一个Java类的byte数组<br>
	 * 将输入类的byte数组中代表java.lang.System的 CONSTANT_Utf8_info常量劫持后的HackSystem类
	 * 执行方法为该类的static main(String[]args)方法，输出结果为该类向System.out/err输出的信息
	 * @param classByte
	 * @return
	 * @author 
	 * @date 2017年9月5日  下午8:16:43
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
