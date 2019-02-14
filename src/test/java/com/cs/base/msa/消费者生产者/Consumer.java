/**
 * 
 */
package com.cs.base.msa.消费者生产者;

import java.util.Vector;

public class Consumer implements Runnable{
	@SuppressWarnings("rawtypes")
	private final Vector queues;
	@SuppressWarnings("unused")
	private final int size;
	
	@SuppressWarnings("rawtypes")
	public Consumer(Vector queues,int size) {
		this.queues = queues;
		this.size = size;
	}
	
	@Override
	public void run() {
		while(true){
			if(queues.size() == 8){
				break;
			}
		}
		while (true) {
			try {
				consume();
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private void consume() throws InterruptedException{
		//队列里面没有值 等待
		while(queues.isEmpty()){
			synchronized (queues) {
				System.out.println("流水线没有商品，机器人b停止工作,等待中..." + Thread.currentThread().getName() );
				queues.wait();
			}
		}
		
		//消耗产品并通知生产者,消耗掉队列中的商品，返回消费者
		synchronized (queues) {
			int t = (Integer)queues.remove(0);
			System.out.println("机器人b消费第" + t + "个鱼罐头");
			queues.notifyAll();
		}
	}
}
