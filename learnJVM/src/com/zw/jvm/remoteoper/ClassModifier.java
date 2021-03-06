package com.zw.jvm.remoteoper;

/**
 * @Description 修改Class文件，暂时只提供修改常量池常量的功能
 * @author 
 * @date 2017年9月1日  上午10:55:36
 * Company: zw
 */
public class ClassModifier {

	/**
	 * @Fields CONSTANT_POOL_COUNT_INDEX 文件中常量池的起始偏移
	 * @author 
	 * @date 2017年9月1日  上午10:56:44
	 */
	private static  final int CONSTANT_POOL_COUNT_INDEX=8;
	
	/**
	 * @Fields CONSTANT_Utf8_info 常量的tag标志
	 * @author 
	 * @date 2017年9月1日  上午11:02:10
	 */
	private static final int CONSTANT_Utf8_info=1;
	
	private static final int[] CONSTANT_ITEM_LENGTH={-1,-1,-1,5,5,9,9,3,3,5,5,5,5};
	
	private static final int u1=1;
	
	private static final int u2=2;
	
	private byte[] classByte;
	
	public ClassModifier(byte[] classByte){
		this.classByte = classByte;
	}
	
	/**
	 * @Description 修改常量池中CONSTANT_Utf8_info常量的内容
	 * @param oldStr 修改前的字符串
	 * @param newStr 修改后的字符串
	 * @return 修改结果
	 * @author 
	 * @date 2017年9月1日  上午11:21:01
	 */
	public byte[] modifyUTF8Constant(String oldStr,String newStr){
		int cpc = getConstantPoolCount();
		int offset = CONSTANT_POOL_COUNT_INDEX+2;
		for(int i = 0;i<cpc;i++){
			int tag = ByteUtils.bytes2Int(classByte, offset, u1);
			if(tag == CONSTANT_Utf8_info){
				int len= ByteUtils.bytes2Int(classByte, offset+u1, u2);
				offset+=(u1+u2);
				String str = ByteUtils.byte2String(classByte, offset, len);
				if(str.equalsIgnoreCase(oldStr)){
					byte[] strBytes = ByteUtils.string2Bytes(newStr);
					byte[] strLen = ByteUtils.int2Bytes(newStr.length(), u2);
					classByte = ByteUtils.bytesReplace(classByte, offset-u2, u2, strLen);
					classByte = ByteUtils.bytesReplace(classByte, offset, len, strBytes);
					return classByte;
				}else{
					offset+=len;
				}
			}else{
				offset+=CONSTANT_ITEM_LENGTH[tag];
			}
		}
		return classByte;
	}
	
	/**
	 * @Description 获取常量池中常量的数量
	 * @return 常量池数量
	 * @author 
	 * @date 2017年9月1日  上午11:23:18
	 */
	public int getConstantPoolCount(){
		return ByteUtils.bytes2Int(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
	}
}
