/**
 * 
 */
package com.cs.socket.nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Service {
	 private static final int BUF_SIZE=1024;
     private static final int PORT = 9999;
     private static final int TIMEOUT= 3000;
     
     
     public static void main(String[] args) {
 		// TODO Auto-generated method stub
    	 selector();
 	}
     
     public static void handleAccept(SelectionKey key) throws IOException{
		 ServerSocketChannel ssChannel = (ServerSocketChannel)key.channel();
		 SocketChannel sc = ssChannel.accept();
		 sc.configureBlocking(false);
		 sc.register(key.selector(), SelectionKey.OP_READ,ByteBuffer.allocate(BUF_SIZE));
	 }
    
     
     
     public static void handleRead(SelectionKey key) throws IOException{
    	 SocketChannel sc = (SocketChannel)key.channel();
    	 ByteBuffer buf = (ByteBuffer)key.attachment();
    	 long bytesRead = sc.read(buf);
    	 while (bytesRead>0) {
			buf.flip();
			while (buf.hasRemaining()) {
				System.out.println(buf.get());
			}
			System.out.println();
			buf.clear();
			bytesRead = sc.read(buf);
		}
    	 if(bytesRead == -1){
    		 sc.close();
    	 }
    	 
     }
     
     
     public static void handleWrite(SelectionKey key) throws IOException{
    	 ByteBuffer buf = (ByteBuffer)key.attachment();
    	 buf.flip();
    	 SocketChannel sc = (SocketChannel)key.channel();
    	 while (buf.hasRemaining()) {
    		 sc.write(buf);
		 }
    	 buf.compact();
     }
     
     
     public static void selector(){
    	 Selector selector = null;
    	 ServerSocketChannel ssc = null;
    	 try {
			
			 //打开选择器
			 selector = Selector.open();
			//打开服务通道
			 ssc = ServerSocketChannel.open();
			 //服务端绑定端口
			 ssc.socket().bind(new InetSocketAddress(PORT));
			 //设置为非阻塞
			 ssc.configureBlocking(false);
			 //将服务通道注册到选择器
			 ssc.register(selector, SelectionKey.OP_ACCEPT);
			 
			 while(true){
				 if(selector.select(TIMEOUT) == 0){
					 System.out.println("==");
					 continue;
				 }
				 Iterator<SelectionKey> iter = selector.selectedKeys().iterator();
				 while (iter.hasNext()) {
					SelectionKey selectionKey = (SelectionKey) iter.next();
					if(selectionKey.isAcceptable()){
						handleAccept(selectionKey);
					}
					if(selectionKey.isReadable()){
						handleRead(selectionKey);
					}
					if(selectionKey.isWritable()){
						handleWrite(selectionKey);
					}
					if(selectionKey.isConnectable()){
						System.out.println("isConnectable=true");
					}
					iter.remove();
				}
			 }
		} catch (ClosedChannelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(selector!=null){
					selector.close();
				}
				if(ssc!=null){
					ssc.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
     }
	
	 
	
}
