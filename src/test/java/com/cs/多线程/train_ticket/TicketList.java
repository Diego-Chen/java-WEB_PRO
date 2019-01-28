package com.cs.多线程.train_ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

public class TicketList {
	static List<String> tickets = new ArrayList<String>();
	static Vector<String> vtickets = new Vector<String>();
    static Queue<String> qeue = new ConcurrentLinkedQueue<String>();

	static TicketList ticket = new TicketList();
	static {
		for(int i = 0 ; i < 1000 ; i++){
			tickets.add("票号" + i);
		}
		
		for(int i = 0 ; i < 100000 ; i++){
			vtickets.add("票号" + i);
		}
		
		for(int i = 0 ; i < 100000 ; i++){
			qeue.add("票号" + i);
		}
	}
	//有10000张火车票，每张票都有一个编号，同时有10个窗口对外售票，如何确保车票的正常售卖？
	public static void main(String[] args) {
		
/*
for(int i = 0 ; i < 10 ; i ++){
ThreadTest thread = ticket.new ThreadTest();
thread.start();

}
for(int i = 0 ; i < 100 ; i ++){
ThreadTest thread = ticket.new ThreadTest();
thread.start();

}
*/
		
		
		/*
		 ConcurrentLinkedQueue是一个并发队列。但凡并发容器，其内部的方法都保证是原子性的。
		 下面的代码中poll()表示从队列的头部获得一个数据，当返回值为null时，代表这个队列已经没有值了。
		 因为队列本身不允许存null值，否则会报空指针异常，因此当返回值为null时，一定表示队列已空（size() == 0）。
		 队列的底层是使用一个叫做CompareAndSet（CAS）的技术实现的，不是加锁的实现，因此在高并发的情况下依然可以拥有很高的效率。
		 */
		for(int i = 0 ; i < 100 ; i ++){
			ThreadTest thread = ticket.new ThreadTest();
			thread.start();

		}
	}
	
	
	
	
	
	
	
	class ThreadTest extends Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub 
			
//			while(tickets.size() > 0){
//				System.out.println("卖了--"+vtickets.remove(0)+">>"+ThreadTest.currentThread().getName());
//				
//			}
			
			
//			while(true){
//				synchronized(vtickets){
//					if(vtickets.size() > 0){
//						System.out.println("卖了--"+vtickets.remove(0)+">>"+ThreadTest.currentThread().getName());
//					}
//				}
//				
//			}
			
			while (true) {                    
				String s = qeue.poll();   
				if (s == null)                      
					break;                    
				else                        
					System.out.println("销售了--" + s);
			}

			
		}
	}
}
