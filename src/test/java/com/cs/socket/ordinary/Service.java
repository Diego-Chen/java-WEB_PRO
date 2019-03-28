/**
 * 
 */
package com.cs.socket.ordinary;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Service {
	
    public void startServer(){  
    	Socket socket = null;
        try {  
        	//创建服务端连接实例,设,监听该端口接收到的连接
        	ServerSocket serverSocket = new ServerSocket(CSUtils.port); 
        	System.out.println("开始监听端口等待客户端连接...");
        	//获取客户端连接
            socket = serverSocket.accept();
            //1.
            //获取字节输入流
            InputStream is = socket.getInputStream();  
            //获取字节输出流返回给客户端数据
            OutputStream os = socket.getOutputStream();
            
            
            if(CSUtils.SOCKETTYPE == CSUtils.SOCKETS)
            //InputStream/OutputStream
            {
            	//获取消息的长度  
                int count = 0;
                byte[] body = null;
                System.out.println("数据接收开始...");
                while(count == 0){
                	count = is.available(); 
                	if(count > 0){
                		 //读取消息并转为String
                		body = new byte[count];  
                		is.read(body);  
                        String message = new String(body,CSUtils.encode);  
                        CSUtils.log(false,"接收数据:",message);
                	}
                }
                System.out.println("数据接收完成");
                String result =  "123";
                body = result.getBytes(CSUtils.encode);
                CSUtils.log(false,"发送数据:",new String(body));
                os.write(body);
            }
            
            if(CSUtils.SOCKETTYPE == CSUtils.SOCKETD)
			//DataOutputStream/DataInputStream
			{
				DataOutputStream dops = new DataOutputStream(os);
				DataInputStream dips = new DataInputStream(is);
				int count = 0;
                byte[] body = null;
                while(count == 0){
                	count = dips.available(); 
                	if(count > 0){
                		 //读取消息并转为String
                		body = new byte[count];  
                		dips.read(body);  
                        String message = new String(body,CSUtils.encode);  
                        CSUtils.log(false,"接收数据:",message);
                	}
                }
                String result =  "123";
                body = result.getBytes(CSUtils.encode);
                CSUtils.log(false,"发送数据:",new String(body));
                dops.write(body);
				
			}
			
            if(CSUtils.SOCKETTYPE == CSUtils.SOCKETO)
			//ObjectOutputStream/ObjectInputStream
			{
				try {
					ObjectOutputStream dops = new ObjectOutputStream(os);
					ObjectInputStream dips = new ObjectInputStream(is);
	        		 //读取消息并转为String
					Object o = dips.readObject();
					CSUtils.log(false,"接收数据:",(String)o);
	                String result =  "123";
	                CSUtils.log(false,"发送数据:",result);
	                dops.writeObject(result);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  
			}
        
            
          socket.close();
            
            
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
