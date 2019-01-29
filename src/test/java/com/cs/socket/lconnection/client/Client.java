/**
 * 
 */
package com.cs.socket.lconnection.client;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Administrator
 *
 */
public class Client {  

	private String serverIp;  
	private int port;  
	public Client(String serverIp, int port) {  
        this.serverIp=serverIp;  
        this.port=port;  
    }  

    public static void main(String[] args) throws UnknownHostException, IOException {  
        Client client = new Client(CUtils.ip,CUtils.port);  
        client.start();  
        
        try {
			Thread.sleep(30000);
			client.stop();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  

    public void start() throws UnknownHostException, IOException {  
        if(CUtils.running)
        	return; 
        //创建socket
        CUtils.socket = new Socket(serverIp,port);  
        System.out.println("本地端口："+CUtils.socket.getLocalPort());  
        //最后一个连接的时间
        CUtils.lastSendTime=System.currentTimeMillis();  
        //状态量置为当前正在进行
        CUtils.running = true;  
        //启动保持长连接的线程，每隔2秒项服务器发一个一个保持连接的心跳消息  
        new Thread(new KeepAliveWatchDog(this)).start();  
        //接受消息的线程，处理消息  
        new Thread(new ReceiveWatchDog(this)).start(); 
    }

    public void stop(){  
        if(CUtils.running)
        	CUtils.running=false;  
    }
}