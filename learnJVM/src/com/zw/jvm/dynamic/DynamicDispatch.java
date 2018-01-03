package com.zw.jvm.dynamic;

/**
 * @Description  ������̬������ʾ
 * 
 * invorkevirtual ָ��ִ�еĵ�һ��������������ȷ�������ߵ�ʵ������
 * �������ε����е�invokevirtualָ��ѳ������е��෽���������ý������˲�ͬ��ֱ�������ϡ�
 * ������̾��� java ���Է�����д�ı��ʡ� 
 * @author 
 * @date 2017��8��30��  ����4:27:31
 * Company: zw
 */
public class DynamicDispatch {
	static abstract class Human {
		protected abstract void sayHello();
	}

	static class Man extends Human {
		@Override
		protected void sayHello() {
			System.out.println("man say hello");
		}
	}

	static class Woman extends Human {

		@Override
		protected void sayHello() {
			System.out.println("woman say hello");
		}
	}

	public static void main(String[] args) {
		Human man = new Man();
		Human woman = new Woman();
		man.sayHello();
		woman.sayHello();
		man = new Woman();
		man.sayHello();
	}
}
