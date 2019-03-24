/**
 * 
 */
package com.cs.多线程.thread_creat;

/**
 * @author Administrator
 *
 */
public class ThreadTest extends Thread{
	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("当前继承Thread创建线程为:" + Thread.currentThread().getName());
	}

}
