package com.zw.jvm.dynamic;

/**
 * @Description  方法动态分派演示
 * 
 * invorkevirtual 指令执行的第一步就是在运行期确定接收者的实际类型
 * 所以两次调用中的invokevirtual指令把常量池中的类方法符号引用解析到了不同的直接引用上。
 * 这个过程就是 java 语言方法重写的本质。 
 * @author 
 * @date 2017年8月30日  下午4:27:31
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
