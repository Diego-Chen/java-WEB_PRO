/**
 * 
 */
package com.cs.多线程.thread_creat;

/**
 * @author Administrator
 *
 */
public class RunnableTest implements Runnable{
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("当前实现Runnable接口创建线程为:" + Thread.currentThread().getName());
	}
}
