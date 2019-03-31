/**
 * 
 */
package com.cs.base.msa.消费者生产者.write;


/**
 * @author Administrator
 * 消费者
 */
public class Consumer extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 15; i++) {
			synchronized (MainTest.list) {
				//没有商品时等待生产
				if(MainTest.list.size()==0){
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
					System.out.println("消费第第"+MainTest.list.get(0)+"个商品");
					MainTest.list.remove(0);
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
