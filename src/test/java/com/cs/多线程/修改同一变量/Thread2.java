/**
 * 
 */
package com.cs.多线程.修改同一变量;

/**
 * @author Administrator
 *
 */
public class Thread2 extends Thread{
	
	private Test t;
	
	/**
	 * 
	 */
	public Thread2(Test t) {
		// TODO Auto-generated constructor stub
		this.t = t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
//			synchronized (this.t) {
//				this.t.j--;
//				System.out.println("Thread2j--" + this.t.j);
//			}
			System.out.println("Thread2j--" + this.t.j.decrementAndGet());
		}
		
	}
}
