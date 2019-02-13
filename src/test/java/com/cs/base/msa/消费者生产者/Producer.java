/**
 * 
 */
package com.cs.base.msa.消费者生产者;

import java.util.Vector;

public class Producer implements Runnable {
	@SuppressWarnings("rawtypes")
	private final Vector queues;
	private final int size;
	
	public Producer(@SuppressWarnings("rawtypes") Vector queues , int size) {
		this.queues = queues;
		this.size = size;
	}
	
	@Override
	public void run() {
		for(int i = 0 ; i < 100 ; i++){
			try {
				//生产商品
				produce(i);
				Thread.sleep(50);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	private void produce(int i) throws InterruptedException{
		
		//商品队列超过设置的上限时，等待消费后继续生产
		while (queues.size() == size) {
			synchronized (queues) {
				System.out.println("商品线已满 " + Thread.currentThread().getName() + ",机器人a正在等待");
				queues.wait();
			}
		}
		
		//当商品被消费到上限以下时，继续 生产商品并通知消费者
		synchronized (queues){
			queues.add(i);
			queues.notifyAll();
			System.out.println("机器人a生产第" + i + "个鱼罐头");
			
		}
	}
}
