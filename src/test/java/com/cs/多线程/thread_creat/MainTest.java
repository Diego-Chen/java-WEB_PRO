/**
 * 
 */
package com.cs.多线程.thread_creat;

import java.util.concurrent.FutureTask;

/**
 * @author Administrator
 *
 */
public class MainTest {
	public static void main(String[] args) {
		
		//1.继承实现  创建Thread的子类，重写run方法，创建子类对象，.start()启动线程
//		ThreadTest tt1 = new ThreadTest();
//		tt1.start();
//		ThreadTest tt2 = new ThreadTest();
//		tt2.start();
		
		//2.实现Runnable接口实现线程 
//		RunnableTest rt1 = new RunnableTest();
//		Thread rtt1 = new Thread(rt1);
//		rtt1.start();
//		Thread rtt2 = new Thread(rt1);
//		rtt2.start();
		
		
		//3.Callable,Future创建线程
		//call方法为线程执行体
		//call()可以有返回值
		//call()方法可以声明抛出异常
		CallableTest ct = new CallableTest();
		FutureTask<String> future = new FutureTask<String>(ct);
		new Thread(future,"有返回值的线程").start();//实质上还是以Callable对象来创建并启动线程
		
//		try {
//			//System.out.println("子线程的返回值："+future.get());
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ExecutionException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}//get()方法会阻塞，直到子线程执行结束才返回
		System.out.println("线程执行完了吗");
	}
}
