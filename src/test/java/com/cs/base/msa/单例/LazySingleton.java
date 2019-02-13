/**
 * 
 */
package com.cs.base.msa.单例;

import javax.transaction.Synchronization;

/**
 * @author Administrator
 *
 */

public class LazySingleton {
	static LazySingleton ton;
	
	/**
	 * 懒汉
	 * @return
	 */
	synchronized public  static  LazySingleton lzTon() {
		if(null == ton){
			ton = new LazySingleton();
		}
		return ton;
	}
	
	
	
	public void print(){
		System.out.println("懒汉式加载单例");
	}
	
}
