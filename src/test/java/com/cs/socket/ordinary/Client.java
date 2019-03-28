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
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	
	public static void main(String[] args) {
		Socket socket = null;
		 try {
				//1.建立TCP连接
			 socket=new Socket(CSUtils.ip,CSUtils.port);
				//2.传输内容
				String content="java客户端";
				CSUtils.log(true,"发送数据:",content);
				OutputStream os=socket.getOutputStream();
				InputStream is = socket.getInputStream();
				
				byte[] bstream=content.getBytes(CSUtils.encode);
				byte[] botream=null;
				
				if(CSUtils.SOCKETTYPE == CSUtils.SOCKETS)
				//InputStream/OutputStream
				{
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					//获取输出流，输送数据到远程服务器
					os.write(bstream);
					//获取输入流，得到服务器返回的数据
					int count = 0; 
					while (count == 0) { 
					   //如果使用available()方法，多次获取更靠谱品
					   //对发发送的数据可能还没有到达，你得到的count是0
					   //调用available()方法有时得到0，这可能是对方还没有响应，也可能是对方已经响应了，但是数据还没有送达本地。对方发送了1000个字节给你，也许分成3批到达，这你就要调用3次available()方法才能将数据总数全部得到。
					   //数据要到达的情况下才能通过available取到数据
					   count = is.available(); 
					   if(count > 0){
						   botream = new byte[count];
						   is.read(botream);
						   CSUtils.log(true,"接收数据:",new String(botream,CSUtils.encode));
					   }
					}
				}
				
				if(CSUtils.SOCKETTYPE == CSUtils.SOCKETD)
				//DataOutputStream/DataInputStream
				{
					DataOutputStream dops = new DataOutputStream(os);
					dops.write(bstream);
					DataInputStream dips = new DataInputStream(is);
					int count = 0; 
					while (count == 0) { 
					   count = dips.available(); 
					   if(count > 0){
						   botream = new byte[count];
						   dips.read(botream);
						   CSUtils.log(true,"接收数据:",new String(botream,CSUtils.encode));
					   }
					}
					
				}
				
				if(CSUtils.SOCKETTYPE == CSUtils.SOCKETO)
				{
					try {
						ObjectOutputStream dops = new ObjectOutputStream(os);
						dops.writeObject(content);
						ObjectInputStream dips = new ObjectInputStream(is);
						Object o = dips.readObject();
						CSUtils.log(true,"接收数据:",(String)o);
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
}
