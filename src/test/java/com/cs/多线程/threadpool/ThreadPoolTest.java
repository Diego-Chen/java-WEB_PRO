/**
 * 
 */
package com.cs.多线程.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 *
 */
public class ThreadPoolTest {
	public static void main(String[] args) {
		//提交一个任务到线程池的逻辑
//		1.判断核心线程是否已满，否，创建核心线程执行任务
//		2.是 判断工作队列是否已满，否，添加到工作队列，等待空闲线程
//		3.是 判断线程池中的线程是否都处于工作状态，没有就创建一个工作线程执行任务，否者交个饱和策略处理这个任务
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
		/**
		 * corePoolSize 核心池的大小，实际上就是核心啊线程的数量，当一个新任务进来，核心线程已经达到此参数上限，将进入缓存队列
		 * maximumPoolSize 线程池最多能创建多少个线程
		 * keepAliveTime 线程没有任务执行时最多保持多久时间会终止。空闲线程的存活时间，默认情况下，只有当线程池中的线程数大于corePoolSize的时候才会起作用
		 * allowCoreThreadTimeOut(boolean)方法，在线程池中的线程数不大于corePoolSize时，keepAliveTime参数也会起作用，直到线程池中的线程数为0；
		 * unit 天-纳秒 keepAliveTime的单位
		 * workQueue 阻塞队列 存储等待执行的任务
		 * ArrayBlockingQueue,PriorityBlockingQueue;
		 * 一般使用下面两种
		   LinkedBlockingQueue; 如果使用这种  线程池的排队策略与BlockingQueue有关。
		   SynchronousQueue;
		   threadFactory	线程工厂，主要用来创建线程；
		   handler 表示当拒绝处理任务时的策略	 四种方式
		ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。 
		ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。 
		ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
		ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
		 */ 
		//ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
//		SynchronousQueue<Runnable> sq = new SynchronousQueue<Runnable>();
//		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 15, 10,TimeUnit.SECONDS ,sq );
//		//交付一个任务到线程池
//		executor.execute(new Thread());
//		
//		System.out.println(executor.getCorePoolSize());
//		System.out.println(executor.getMaximumPoolSize());
		
		//交付一个任务到线程池，通过Feature获取返回值
		
//		executor.submit(null);
//		executor.shutdown();
//		executor.shutdownNow();
		
		
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<Runnable>(5));
        for(int i=0;i<20;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+ executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
	}
	
	
//	public void static createPool(){
//		Executors.newCachedThreadPool();
//		Executors.newSingleThreadExecutor();
//		Executors.newFixedThreadPool(10);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
