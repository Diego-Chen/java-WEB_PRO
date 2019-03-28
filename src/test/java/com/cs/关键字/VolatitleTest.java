/**
 * 
 */
package com.cs.关键字;

/**
 * @author Administrator
 *
 */
public class VolatitleTest {
	
	public static volatile VolatitleTest instance;
	
	//经典案例
	public static VolatitleTest getInstance(){
		if(instance == null){
			synchronized (VolatitleTest.class) {
				if(instance == null){
					instance = new VolatitleTest();
				}
			}
		}
		return instance;
	}
	
	
	
	public volatile int inc = 0;
	public void increase(){
		inc++;
	}
	
	
	
	public static void main(String[] args) {
		final VolatitleTest test = new VolatitleTest();
		for (int i = 0; i < 100; i++) {
			new Thread(){
				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int j = 0; j < 10000; j++){
						test.increase();
					}
				}
			}.start();
			//保证前面的线程执行完毕
			while(Thread.activeCount() >1)
				Thread.yield();
			System.out.println(test.inc);
		}
	}
}
