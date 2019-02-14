/**
 * 
 */
package com.cs.socket.lconnection.server;


/**
 * @author Administrator
 *
 */
public class DefaultObjectAction implements ObjectAction {

	/* (non-Javadoc)
	 * @see com.cs.socket.lconnection.ObjectAction#doAction(java.lang.Object, com.cs.socket.lconnection.Server)
	 */
	@Override
	public Object doAction(Object rev, Server server) {
		// TODO Auto-generated method stub
		System.out.println("处理并返回："+rev);  
        return rev;  
	}

}
