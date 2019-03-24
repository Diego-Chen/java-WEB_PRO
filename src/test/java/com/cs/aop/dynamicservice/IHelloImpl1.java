/**
 * 
 */
package com.cs.aop.dynamicservice;


/**
 * @author Administrator
 *
 */
public class IHelloImpl1 implements IHello {

	/* (non-Javadoc)
	 * @see aop.service.IHello#sayHello(java.lang.String)
	 */
	@Override
	public void sayHello(String str) {
		// TODO Auto-generated method stub
		System.out.println("ddd" + str);
	}

}
