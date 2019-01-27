/**
 * 
 */
package com.cs.socket.lconnection.client;

import java.io.IOException;
import java.io.ObjectOutputStream;

import com.cs.socket.lconnection.server.KeepAlive;

/**
 * @author Administrator
 *
 */
public class KeepAliveWatchDog implements Runnable {

	long checkDelay = 10;  
    long keepAliveDelay = 2000;  
    private Client client;
    /**
	 * 
	 */
	public KeepAliveWatchDog(Client client) {
		// TODO Auto-generated constructor stub
		this.client = client;
	}
    
    
    public void run() {  
        while(CUtils.running){  
            if(System.currentTimeMillis()-CUtils.lastSendTime>keepAliveDelay){  
                try {  
                	KeepAlive keep = new KeepAlive();
                	ObjectOutputStream oos = new ObjectOutputStream(CUtils.socket.getOutputStream());  
                    oos.writeObject(keep);  
                    System.out.println("发送：\t"+keep);  
                    oos.flush();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                    client.stop();  
                }  
                CUtils.lastSendTime = System.currentTimeMillis();  
            }else{  
                try {  
                    Thread.sleep(checkDelay);  
                } catch (InterruptedException e) {  
                    e.printStackTrace();  
                    client.stop();  
                }  
            }  
        }  
    }  

}
