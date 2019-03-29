/**
 * 
 */
package com.cs.多线程.修改同一变量;

/**
 * @author Administrator
 *
 */
public class Thread1 extends Thread{
	
	private Test t;
	
	/**
	 * 
	 */
	public Thread1(Test t) {
		// TODO Auto-generated constructor stub
		this.t = t;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
//			synchronized (this.t) {
//				this.t.j++;
//				System.out.println("Thread1j++" + this.t.j);
//			}
			
			System.out.println("Thread1j++"+this.t.j.addAndGet(1));
		}
	}
}
