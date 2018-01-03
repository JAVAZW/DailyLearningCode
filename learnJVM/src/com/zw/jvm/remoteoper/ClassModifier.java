package com.zw.jvm.remoteoper;

/**
 * @Description �޸�Class�ļ�����ʱֻ�ṩ�޸ĳ����س����Ĺ���
 * @author 
 * @date 2017��9��1��  ����10:55:36
 * Company: zw
 */
public class ClassModifier {

	/**
	 * @Fields CONSTANT_POOL_COUNT_INDEX �ļ��г����ص���ʼƫ��
	 * @author 
	 * @date 2017��9��1��  ����10:56:44
	 */
	private static  final int CONSTANT_POOL_COUNT_INDEX=8;
	
	/**
	 * @Fields CONSTANT_Utf8_info ������tag��־
	 * @author 
	 * @date 2017��9��1��  ����11:02:10
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
	 * @Description �޸ĳ�������CONSTANT_Utf8_info����������
	 * @param oldStr �޸�ǰ���ַ���
	 * @param newStr �޸ĺ���ַ���
	 * @return �޸Ľ��
	 * @author 
	 * @date 2017��9��1��  ����11:21:01
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
	 * @Description ��ȡ�������г���������
	 * @return ����������
	 * @author 
	 * @date 2017��9��1��  ����11:23:18
	 */
	public int getConstantPoolCount(){
		return ByteUtils.bytes2Int(classByte, CONSTANT_POOL_COUNT_INDEX, u2);
	}
}
