/**
 * 
 */
package com.cs.aop.service;


/**
 * @author Administrator
 *
 */
public class ProxyHello implements IHello{
	
	private IHello hello;
	public ProxyHello(IHello hello){
		super();
		this.hello = hello;
	}
	
	
	@Override
	public void sayHello(String str) {
		// TODO Auto-generated method stub
		Logger.start();
		hello.sayHello(str);
		Logger.end();
	}

}
