/**
 * 
 */
package com.cs.base.theory;

/**
 * @author Administrator
 *
 */
public class TEST {
	public static void main(String[] args) {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		TEST test = new TEST();
		try {
			test.wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
