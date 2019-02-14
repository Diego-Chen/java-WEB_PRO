/**
 * 
 */
package com.cs.socket.lconnection.client;


/**
 * @author Administrator
 *
 */
public class DefaultObjectAction implements ObjectAction {

	/* (non-Javadoc)
	 * @see com.cs.socket.lconnection.ObjectAction#doAction(java.lang.Object, com.cs.socket.lconnection.Server)
	 */
	  public void doAction(Object obj,Client client) {  
          System.out.println("处理：\t"+obj.toString());  
      }  

}
