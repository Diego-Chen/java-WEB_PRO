/**
 * 
 */
package com.cs.aop.service;

/**
 * @author Administrator
 *
 */
public class IHelloImpl implements IHello {
	
	@Override
	public void sayHello(String str) {
		// TODO Auto-generated method stub
		System.out.println("hello" + str);
	}
}
