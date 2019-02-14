/**
 * 
 */
package com.cs.socket.lconnection.server;


/**
 * @author Administrator
 *
 */
public interface ObjectAction {
	//要处理客户端发来的对象，并返回一个对象，可实现该接口。  
	Object doAction(Object rev, Server server);  
}
