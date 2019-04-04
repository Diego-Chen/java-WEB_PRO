/**
 * 
 */
package com.cs.设计模式.单例模式;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Singleton1 implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public static volatile Singleton1 instance;
	
	private  Singleton1() {
		//防止反射
		if(instance != null){
			throw new RuntimeException();
		}
	}
	//反序列化调用
	private Object readResolve() {
		return instance;
	}
	
	
	public static Singleton1 getIntance(){
		if(null == instance){
			synchronized (Singleton1.class) {
				if(null == instance){
					instance = new Singleton1();
				}
			}
		}
		return instance;
	}
}
