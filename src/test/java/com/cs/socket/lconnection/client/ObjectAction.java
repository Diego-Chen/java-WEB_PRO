/**
 * 
 */
package com.cs.socket.lconnection.client;


/**
 * @author Administrator
 *
 */
public interface ObjectAction {
	//处理服务端发回的对象，可实现该接口。    
	void doAction(Object obj,Client client);  
}
