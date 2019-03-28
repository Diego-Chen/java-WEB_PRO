/**
 * 
 */
package com.cs.jvm;

/**
 * @author Administrator
 *
 */
public class MainTest {
	private int count = 0;
	public void testAdd(){
		count ++ ;
		testAdd();
	}
	
	public void test(){
	    try {
	    	testAdd();
		} catch (Throwable e) {
			System.out.println("栈的深度为:" + count);
		}
		
		
	}
	
	public static void main(String[] args) {
		new MainTest().test();
	}
}
