/**
 * 
 */
package com.cs.设计模式.单例模式;

/**
 * @author Administrator
 *
 */
public class Singleton4 {
	
	private static class Ton{
		private static final Singleton4 instance = new Singleton4();
	}
	
	private Singleton4() {
		if(null != Ton.instance)
			throw new RuntimeException();
	}
	
	
	
	public static Singleton4 getIntance(){
		return Ton.instance;
	}
}
