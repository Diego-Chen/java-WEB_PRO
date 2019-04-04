/**
 * 
 */
package com.cs.设计模式.单例模式;

/**
 * @author Administrator
 *
 */
public class Singleton2 {
	public static Singleton2 instance = new Singleton2();
	
	//显示声明私有构造方法，防止通过构造方法创建对象
	private Singleton2() {
		if(instance == null)
			throw new RuntimeException();
	}
	
	private Object readResolve(){
		return instance;
	}
	
	
	public Singleton2 getInstance(){
		return instance;
	}
	
	
	
}
