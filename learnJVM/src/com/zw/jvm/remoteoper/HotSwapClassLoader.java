package com.zw.jvm.remoteoper;

/**
 * @Description Ϊ�˶������ִ���������ļ�����<br>
 * ��defineClass�������ų���  ֻ���ⲿ��ʽ���õ�ʱ��Ż�ʹ�õ�loadbyte����
 * �����������ʱ����Ȼ����ԭ�е�˫��ί�ɹ�������loadClass���������
 * 
 * @author 
 * @date 2017��8��31��  ����3:21:26
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
