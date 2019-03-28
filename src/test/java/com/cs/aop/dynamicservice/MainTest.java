/**
 * 
 */
package com.cs.aop.dynamicservice;

/**
 * @author Administrator
 *
 */
public class MainTest {
	public static void main(String[] args) {
		//如果我们需要日志功能，则使用代理类
		IHello hello = (IHello)new DynamicProxyHello().bind(new IHelloImpl(),new ILoggerImpl());
		//不需要使用日志功能，直接使用目标类
//		IHello hello1 = new IHelloImpl();
//		hello1.sayHello("明天");
		hello.sayHello("太阳");
		
		
		
	}
}
