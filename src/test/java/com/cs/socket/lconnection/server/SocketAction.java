/**
 * 
 */
package com.cs.socket.lconnection.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * @author Administrator
 *
 */
public class SocketAction implements Runnable {

	Socket s;  
    boolean run; 
    
    long lastReceiveTime = System.currentTimeMillis();  
    public SocketAction(Socket s,boolean run) {  
        this.s = s;  
        this.run = run;
    }  
    public void run() {  
        while(LUtils.running && run){  
        	//处理超过3秒，直接关闭socket
            if(System.currentTimeMillis()-lastReceiveTime>LUtils.receiveTimeDelay){  
                overThis();  
            }else{  
                try {  
                	//获取字节输入流
                    InputStream in = s.getInputStream();  
                    //返回可读取的字节数的估计值
                    if(in.available()>0){  
                    	//对象输入流,这个需要前后端一致
                        ObjectInputStream ois = new ObjectInputStream(in);  
                        Object obj = ois.readObject();  
                        lastReceiveTime = System.currentTimeMillis();  
                        System.out.println("接收：\t"+obj);  
                        //actionMapping 里面存的是实现ObjectAction接口的对象
                        ObjectAction oa = LUtils.actionMapping.get(obj.getClass());  
                        oa = oa==null?new DefaultObjectAction():oa;  
                        Object out = oa.doAction(obj,LUtils.server);  
                        if(out!=null){  
                            ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());  
                            oos.writeObject(out);  
                            oos.flush(); 
                        }  
                    }else{  
                        Thread.sleep(10);  
                    }  
                } catch (Exception e) {  
                    e.printStackTrace();  
                    overThis();  
                }   
            }  
        }  
    }  

    private void overThis() {  
        if(run)run=false;  
        if(s!=null){  
            try {  
                s.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        System.out.println("关闭："+s.getRemoteSocketAddress());  
    }  


}
