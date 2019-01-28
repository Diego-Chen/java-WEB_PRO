/**
 * 
 */
package com.cs.多线程.中断;

/**
 * @author Administrator
 * 测试线程中断
 */
public class MainTest {
	
	public static void main(String[] args) {
		TestThread thread = new TestThread();
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread.interrupt();
		System.out.println("中断之后:" +thread.isInterrupted() );
	}
	
}

class  TestThread  extends Thread  {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for (int j = 0; j < 20; j++) {
			System.out.println("输出:" + j + "--中断状态:" +this.isInterrupted() );
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				break;
			}
		}
		System.out.println("线程执行完成");
	}
}
