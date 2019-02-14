/**
 * 
 */
package com.cs.多线程.中断;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 * 用socket 线程中断
 */
public class SocketThread extends Thread {
	private ServerSocket socket;  
	
	public static void main( String args[] ) throws Exception {  
	   SocketThread thread = new SocketThread();  
	   System.out.println("启动线程" ); 
	   thread.start();
	   //这里假设3秒没有客户端连接就需要结束线程
	   Thread.sleep(3000);  
	   System.out.println("中断线程" ); 
	   thread.interrupt();
	   System.out.println("关闭socket通道");
	   thread.socket.close();  
	 }  
	  
	@Override
	public void run() {  
	    try {  
	      socket = new ServerSocket(12345);  
	    } catch ( IOException e ) {  
	      return;  
	    }  
	    while (! Thread.currentThread().isInterrupted()) {  
	      try {  
	    	  System.out.println("等待客户端连接...");  
	    	  Socket sock = socket.accept();  
	    	  System.out.println("客户端socket:" + sock.toString());
	      } catch ( IOException e ) {  
	    	  System.out.println("I/O异常");  
	    	  break;
	      }  
	    }  
	    System.out.println("线程执行结束" );  
	 }  
}
