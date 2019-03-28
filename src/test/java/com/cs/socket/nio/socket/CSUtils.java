/**
 * 
 */
package com.cs.socket.nio.socket;

/**
 * @author Administrator
 *
 */
public class CSUtils {
	static String ip = "127.0.0.1"; 
	static int port = 12345;
	static String encode = "GBK";
	
	
	static int SOCKETTYPE = 1; 
	static int SOCKETS = 1; 
	static int SOCKETD = 2;
	static int SOCKETO = 3; 
	
	
	static void log(Boolean cos, String... vs){
		StringBuffer sb = new StringBuffer();
		if(cos)
			sb.append("客户端->");
		else
			sb.append("服务端->");
		
		for (String string : vs) {
			sb.append(string);
		}
		System.out.println(sb.toString());
	}
}
