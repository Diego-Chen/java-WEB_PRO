/**
 * 
 */
package com.cs.base.msa.锁;

/**
 * @author Administrator
 *
 */
public class Difference {
	//修饰代码块
	public  void  test1(){
		synchronized(this){
			int i = 0 ;
			while( i < 5 ){
				System.out.println(Thread.currentThread().getName() +  "-执行到第"+ i + "步");
				i ++ ;
			}
		}
		
		System.out.println("同步代码结束");
		int j = 0 ;
		while( j < 5 ){
			System.out.println("同步之后的逻辑"+ j );
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j ++ ;
		}
	}
	
	//修饰方法
	public synchronized void test2(){
		int i = 0 ;
		while( i < 5 ){
			System.out.println(Thread.currentThread().getName() +  "-执行到第"+ i + "步");
			i ++ ;
		}
	}
	
	public static void main(String[] args) {
		final Difference dif = new Difference();
		Thread read1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
			    dif.test1();
			}
		});
		
		Thread read2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				dif.test2();
			}
		});
		read1.start();
		read2.start();
	}
}
