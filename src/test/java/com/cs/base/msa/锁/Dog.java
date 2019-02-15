package com.cs.base.msa.锁;

public class Dog {
	//修饰代码块
	public void test1(){
//		synchronized (this) {
			int i = 0 ;
			while( i < 5 ){
				System.out.println(Thread.currentThread().getName() +  "-执行到第"+ i + "步");
				i ++ ;
			}
//		}
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
		final Dog dog = new Dog();
		Thread read1 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				dog.test1();
			}
		});
		
		
		Thread read2 = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				dog.test2();
			}
		});
		read1.start();
		read2.start();
	}
}
