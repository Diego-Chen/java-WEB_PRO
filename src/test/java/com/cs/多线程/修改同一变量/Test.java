/**
 * 
 */
package com.cs.多线程.修改同一变量;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 *
 */
public class Test {
	public AtomicInteger  j =  new AtomicInteger();
	
	public static void main(String[] args) {
		Test t = new Test();
		Thread1 t1 = new Thread1(t);
		Thread1 t2 = new Thread1(t);
		Thread2 t3 = new Thread2(t);
		Thread2 t4 = new Thread2(t);
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}
