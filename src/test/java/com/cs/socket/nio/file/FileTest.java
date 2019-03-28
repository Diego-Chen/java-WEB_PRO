/**
 * 
 */
package com.cs.socket.nio.file;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import javax.swing.Box.Filler;

/**
 * @author Administrator
 *
 */
public class FileTest {
	public static void main(String[] args) {
		
		
		 
		 
	
		 
//		iofile();
		niofile();
	}
	
	
	public static void niofile(){
		RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("test.txt","rw");
            //获取文件通道
            FileChannel fileChannel = aFile.getChannel();
            //分配空间
            ByteBuffer buf = ByteBuffer.allocate(2048);
            
            System.out.println(buf.position());
            System.out.println(buf.limit());
            //把数据写入缓存区
            int bytesRead = fileChannel.read(buf);
            System.out.println(bytesRead);
            while(bytesRead != -1)
            {
                //初始化下，从首位开始读取
            	buf.flip();
            	
            	System.out.println(buf.limit());
            	//从缓存读取数据
                while(buf.hasRemaining())
                {
                    System.out.print((char)buf.get());
                }
                buf.clear();
                System.out.println();
                System.out.println(buf.position());
                System.out.println(buf.limit());
                bytesRead = fileChannel.read(buf);
                System.out.println(bytesRead);
            
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
	}
	
	public static void iofile(){
		InputStream in = null;
		try {
			in = new BufferedInputStream(new FileInputStream("test.txt"));
			byte[] buf = new byte[1024];
			int bytesRead = in.read(buf);
			while(bytesRead != -1){
				for(int i = 0 ; i < bytesRead ; i++){
					System.out.println((char)buf[i]);
				}
				bytesRead = in.read(buf);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(in != null)
					in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
