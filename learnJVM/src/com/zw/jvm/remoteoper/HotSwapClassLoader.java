package com.zw.jvm.remoteoper;

/**
 * @Description 为了多次载入执行类而加入的加载器<br>
 * 把defineClass方法开放出来  只有外部显式调用的时候才会使用到loadbyte方法
 * 由虚拟机调用时，仍然按照原有的双亲委派规则适用loadClass方法类加载
 * 
 * @author 
 * @date 2017年8月31日  下午3:21:26
 * Company: zw
 */
public class HotSwapClassLoader extends ClassLoader{

	public HotSwapClassLoader(){
		super(HotSwapClassLoader.class.getClassLoader());
	}
	
	public Class loadByte(byte[] classByte){
		return defineClass(null,classByte,0,classByte.length);
	}
}
