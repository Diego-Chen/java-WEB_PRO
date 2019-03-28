/**
 * 
 */
package com.cs.aop.dynamicservice;


/**
 * @author Administrator
 *
 */
public class IHeloImpl2 implements IHello {

	/* (non-Javadoc)
	 * @see aop.service.IHello#sayHello(java.lang.String)
	 */
	@Override
	public void sayHello(String str) {
		// TODO Auto-generated method stub
		System.out.println("哈嗨哟" + str);
	}

}
