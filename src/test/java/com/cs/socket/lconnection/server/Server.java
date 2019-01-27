/**
 * 
 */
package com.cs.socket.lconnection.server;



/**
 * @author Administrator
 *
 */
public class Server {  
	private Thread connWatchDog;  

    public static void main(String[] args) {  
        Server server = new Server();  
        server.start();  
    }  

    public void start(){  
    	//一旦开始 ， 状态量置为线程进行中，并且不许多次启用线程
        if(LUtils.running)
        	return;  
        //当前状态
        LUtils.running = true;  
        //传入对象,start方法将调用线程的run实现
        connWatchDog = new Thread(new ConnWatchDog());  
        connWatchDog.start();  
    }  

    @SuppressWarnings("deprecation")  
    public void stop(){  
    	//结束线程
        if(connWatchDog!=null)
         	connWatchDog.stop(); 
        
        //状态量还原
        if(LUtils.running)
        	LUtils.running=false;  
        
    }  

}