/**
 * 
 */
package com.cs.socket.lconnection.client;

import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 *
 */
public class CUtils {
	
	static String ip = "127.0.0.1";
	static int port = 65432;
	
	 
	  static Socket socket;  
	  ////连接状态  
	  static boolean running = false;
	  //最后一次发送数据的时间  
	  static long lastSendTime; 
	  
		//用于保存接收消息对象类型及该类型消息处理的对象  
		@SuppressWarnings("rawtypes")
		static ConcurrentHashMap<Class, ObjectAction>  actionMapping  = new ConcurrentHashMap<Class,ObjectAction>();
		
		
		   /**  
	     * 添加接收对象的处理对象。  
	     * @param cls 待处理的对象，其所属的类。  
	     * @param action 处理过程对象。  
	     */  
		public void addActionMap(Class<Object> cls,ObjectAction action){
	        actionMapping.put(cls, action);  
	    }  
}
