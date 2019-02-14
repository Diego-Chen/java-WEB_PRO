/**
 * 
 */
package com.cs.socket.lconnection.client;

import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * @author Administrator
 *
 */
public class ReceiveWatchDog implements Runnable {
	
	private Client client;

	public ReceiveWatchDog(Client client ) {
		// TODO Auto-generated constructor stub
		this.client = client;
	}
	
	
	public void run() {  
        while(CUtils.running){  
            try {  
                InputStream in = CUtils.socket.getInputStream();  
                if(in.available()>0){  
                    ObjectInputStream ois = new ObjectInputStream(in);  
                    Object obj = ois.readObject();  
                    System.out.println("接收：\t"+obj);  
                    ObjectAction oa = CUtils.actionMapping.get(obj.getClass());  
                    oa = oa==null?new DefaultObjectAction():oa;  
                    oa.doAction(obj, this.client);  
                }else{  
                    Thread.sleep(10);  
                }  
            } catch (Exception e) {  
                e.printStackTrace();  
                this.client.stop();  
            }   
        }  
    } 

}
