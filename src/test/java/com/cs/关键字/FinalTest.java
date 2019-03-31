/**
 * 
 */
package com.cs.关键字;

import java.util.Random;

/**
 * @author Administrator
 *
 */
public class FinalTest {
	public final int t = new Random(100).nextInt();
	public final static int J = 15;
	
	
	public static void main(String[] args) {
		FinalTest h = new FinalTest();
		System.out.println(h.t);
		System.out.println(J);
	}
}
