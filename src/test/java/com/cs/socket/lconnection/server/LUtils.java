/**
 * 
 */
package com.cs.socket.lconnection.server;

import java.util.concurrent.ConcurrentHashMap;


/**
 * @author Administrator
 *
 */
public class LUtils {
	
	@SuppressWarnings("rawtypes")
	static ConcurrentHashMap<Class, ObjectAction> actionMapping = new ConcurrentHashMap<Class,ObjectAction>();  
	
	static int port = 65432;  
	
	static Server server;  
	
	static long receiveTimeDelay=3000; 
	
	static boolean running;
	
    public void addActionMap(Class<Object> cls,ObjectAction action){  
    	actionMapping.put(cls, action);  
    }  
}
