/**
 * 
 */
package com.cs.base.msa.单例;


/**
 * @author Administrator
 * 懒汉单例
 */

public class LazySingleton {
	static LazySingleton ton = null;
	
	//1
    public  static  LazySingleton lzTon1() {
		if(null == ton){
			ton = new LazySingleton();
		}
		return ton;
	}
    
    //2
    synchronized public  static  LazySingleton lzTon2() {
		if(null == ton){
			ton = new LazySingleton();
		}
		return ton;
	}
}
