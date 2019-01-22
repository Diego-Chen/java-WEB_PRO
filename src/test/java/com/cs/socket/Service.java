/**
 * 
 */
package com.cs.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
	
    public void startServer(){  
    	Socket socket = null;
        try {  
        	//创建服务端连接实例,设置端口号为8889,监听该端口接收到的连接
        	ServerSocket serverSocket = new ServerSocket(8889); 
        	//获取客户端连接
            socket = serverSocket.accept();
            //获取字节输入流
            InputStream input = socket.getInputStream();  
            //获取消息的长度  
            int length =   input.available();  
            //读取消息并转为String
            byte[] body = new byte[length];  
            input.read(body);  
            String message = new String(body,"GBK");  
            System.out.println("服务端:接收到客户端传来的消息为->"+message);
            
            
            //获取字节输出流返回给客户端数据
            OutputStream out = socket.getOutputStream();
            String result =  "java服务端";
            body = result.getBytes("GBK");
            System.out.println("服务端:发送数据到客户端->" + new String(body));
            out.write(body);
            
            
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }finally{
        	//数据传输关闭连接
        	if(socket!=null){
        		try{
        			socket.close();
        		}catch(IOException e) { 
        			e.printStackTrace(); 
        		}
        	}
        }
    }  
      
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Service server = new Service();  
	    server.startServer();  
	}
}
