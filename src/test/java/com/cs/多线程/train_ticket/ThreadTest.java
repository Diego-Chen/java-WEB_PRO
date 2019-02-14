package com.cs.多线程.train_ticket;

public class ThreadTest {

}

/*
  
 	
  1.start方法
  start()用来启动一个线程，当调用start方法后，系统才会开启一个新的线程来执行用户定义的子任务，在这个过程中，会为相应的线程分配需要的资源。
  2.run方法
  run()方法是不需要用户来调用的，当通过start方法启动一个线程之后，当线程获得了CPU执行时间，便进入run方法体去执行具体的任务。注意，继承Thread类必须重写run方法，在run方法中定义具体要执行的任务。
  3.sleep方法
	  sleep(long millis)     //参数为毫秒
	  sleep(long millis,int nanoseconds)    //第一参数为毫秒，第二个参数为纳秒
	       睡眠线程，让出CPU，不会释放锁，阻塞线程	当线程睡眠时间满后，不一定会立即得到执行，因为此时可能CPU正在执行其他的任务。所以说调用sleep方法相当于让线程进入阻塞状态。
  4.yield
  	     	   让出CPU，不会释放锁，不阻塞线程	yield不能控制具体的交出CPU的时间，另外，yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会。调用yield方法并不会让线程进入阻塞状态，而是让线程重回就绪状态，它只需要等待重新获取CPU执行时间
  5.join
		join()
		join(long millis)     //参数为毫秒
		join(long millis,int nanoseconds)    //第一参数为毫秒，第二个参数为纳秒
	在main线程中，调用thread.join方法，则main方法会等待thread线程执行完毕或者等待一定的时间。实际为调用了Object的wait方法
  6.interrupt
  			结束阻塞线程
  	中断的意思。单独调用interrupt方法可以使得处于阻塞状态的线程抛出一个异常，也就说，它可以用来中断一个正处于阻塞状态的线程；另外，通过interrupt方法和isInterrupted()方法来停止正在运行的线程。
  	直接调用interrupt方法不能中断正在运行中的线程。
  	调用interrupt方法相当于将中断标志位置为true，调用isInterrupted()判断中断标志是否被置位来中断线程的执行。
  	一般情况下不建议通过这种方式来中断线程，一般会在MyThread类中增加一个属性 isStop来标志是否结束while循环，然后再在while循环中判断isStop的值。就可以在外面通过调用setStop方法来终止while循环。
  7.stop方法  它是一个不安全的方法。因为调用stop方法会直接终止run方法的调用，并且会抛出一个ThreadDeath错误，如果线程持有某个对象锁的话，会完全释放锁，导致对象状态不一致。所以stop方法基本是不会被用到的。
  8，destroy
 线程属性方法
 	getId	用来得到线程ID
 	getName和setName 用来得到或者设置线程名称。
 	getPriority和setPriority		用来获取和设置线程优先级
 	setDaemon和isDaemon		用来设置线程是否成为守护线程和判断线程是否是守护线程。
 	守护线程和用户线程的区别在于：守护线程依赖于创建它的线程，而用户线程则不依赖。举个简单的例子：如果在main线程中创建了一个守护线程，当main方法运行完毕之后，守护线程也会随着消亡。而用户线程则不会，用户线程会一直运行直到其运行完毕。在JVM中，像垃圾收集器线程就是守护线程。

currentThread()静态方法 获取当前线程
*/ 
/*
 while(isAlive()){
 	long delay = millis - now;
 	if(delay <= 0){
 		break;
 	}
 	wait(delay);
 	now = System.currentTimeMillis() - base;
 }
 */


//写的不错的博客
//https://www.cnblogs.com/renhui/

