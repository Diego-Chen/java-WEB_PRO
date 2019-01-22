/**
 * 
 */
package com.cs.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	public static void main(String[] args) {
		 try {
				//1.建立TCP连接
				String ip="127.0.0.1";  
				//端口
				int port=8889;    
				Socket sck=new Socket(ip,port);
				//2.传输内容
				String content="java客户端";
				System.out.println("客户端:发送的请求数据为->"+content);
				byte[] bstream=content.getBytes("GBK"); 
				//获取输出流，输送数据到远程服务器
				OutputStream os=sck.getOutputStream();
				os.write(bstream);
				
				
				//获取输入流，得到服务器返回的数据
				InputStream is = sck.getInputStream();
				int len = is.available();
				System.out.println("数据长度" + len);
				bstream = new byte[len];
				is.read(bstream);
				System.out.println("客户端:接收到服务端返回的消息为->"+new String(bstream,"GBK"));
				
				
				//3.关闭连接
				sck.close();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
