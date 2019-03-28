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
		
		
		String a = "abc";
		String b = new String("abc");
		String c = "ab" + "c";
		System.out.println(a==b);
		System.out.println(b==c);
		System.out.print(a==c);
		
		
		
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		TEST test = new TEST();
//		try {
//			test.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
