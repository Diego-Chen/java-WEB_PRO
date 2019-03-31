/**
 * 
 */
package com.cs.base.msa.消费者生产者.write;


/**
 * @author Administrator
 *	生产者
 */
public class Producer extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//生产100个商品
		for (int i = 0; i < 30; i++) {
			
			synchronized (MainTest.list) {
				//超过10个等待消费
				if(MainTest.list.size() == 10){
					try {
						MainTest.list.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
			
			synchronized (MainTest.list) {
				
				try {
					MainTest.list.add(i);
					System.out.println("生产第"+ i +"个商品");
					Thread.sleep(100);
					MainTest.list.notifyAll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		
		}
	}
}
