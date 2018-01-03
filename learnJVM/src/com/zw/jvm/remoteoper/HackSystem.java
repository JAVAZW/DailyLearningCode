package com.zw.jvm.remoteoper;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * @Description 为JavaClass劫持java.lang.System提供支持
 * 	除了out和err外 其余的都直接转发给system处理
 * @author 
 * @date 2017年9月5日  下午8:03:41
 * Company: zw
 */
public class HackSystem {
	
	private static final InputStream in = System.in;
	
	private static ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	
	public static final PrintStream out = new PrintStream(buffer);
	
	public static final PrintStream err = out;
	
	public static String getBufferString(){
		return buffer.toString();
	}
	
	public static void clearBuffer(){
		buffer.reset();
	}
	
	public static void setSecurityManager(final SecurityManager s){
		System.setSecurityManager(s);
	}
	
	public static SecurityManager getSecurityManager(){
		return System.getSecurityManager();
	}
	
	public static long currentTimeMillis(){
		return System.currentTimeMillis();
	}
	
	public static void arraycopy(Object src,int srcPos,Object dest,int destPos,int length){
		System.arraycopy(src, srcPos, dest, destPos, length);
	}
	
	public static int identifyHashCode(Object x){
		return System.identityHashCode(x);
	}
}
