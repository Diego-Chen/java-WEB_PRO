/**
 * 
 */
package com.cs.aop.service;

/**
 * @author Administrator
 *
 */
public class MainTest {
	public static void main(String[] args) {
		IHello hello = new ProxyHello(new IHelloImpl());
		hello.sayHello("明天");
	}
}
