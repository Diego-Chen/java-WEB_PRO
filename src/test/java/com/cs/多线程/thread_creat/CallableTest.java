/**
 * 
 */
package com.cs.多线程.thread_creat;

import java.util.concurrent.Callable;



/**
 * @author Administrator
 *
 */
public class CallableTest implements Callable<String>{
	
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("当前实现Callable接口创建线程为:" + Thread.currentThread().getName());
		for (int i = 0; i <10; i++) {
			Thread.sleep(1000);
		}
		
		
		
		return "100";
	}
}
