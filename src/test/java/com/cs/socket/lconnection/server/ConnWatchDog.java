/**
 * 
 */
package com.cs.socket.lconnection.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Administrator
 *
 */
public class ConnWatchDog implements Runnable {

	/**
	 * 
	 */
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run(){  
        try {  
        	//请求传入队列的最大长度5
            ServerSocket ss = new ServerSocket(LUtils.port,5);  
            while(LUtils.running){
            	//得到客户端请求的socket对象
                Socket s = ss.accept();
                SocketAction action = new SocketAction(s,true);
                new Thread(action).start();
            }
        } catch (IOException e){ 
            e.printStackTrace();  
            LUtils.server.stop();  
        }  

    }  
}
