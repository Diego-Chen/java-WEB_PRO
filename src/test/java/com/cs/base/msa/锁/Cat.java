/**
 * 
 */
package com.cs.base.msa.锁;

/**
 * @author Administrator
 *
 */
public class Cat {
	//修饰代码块
	public static void test(){
		synchronized(Cat.class){
			int i = 0;
			do {
				System.out.println(Thread.currentThread().getName() + "当前运行:" + i);
				i ++;
			} while (i < 5);
		}
	}
	
	public static synchronized void test1(){
		int i = 0;
		do {
			System.out.println(Thread.currentThread().getName() + "当前运行:" + i);
			i ++;
		} while (i < 5);
	}
	
	public static void main(String[] args) {
		Thread read = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Cat.test();
			}
		});
		
		Thread read1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Cat.test1();
			}
		});
		read.start();
		read1.start();
	}
}
