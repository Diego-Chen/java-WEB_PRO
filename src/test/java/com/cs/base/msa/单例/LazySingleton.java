/**
 * 
 */
package com.cs.base.msa.单例;

import java.io.Serializable;


/**
 * @author Administrator
 * 懒汉单例
 */

public class LazySingleton implements Serializable{
	private static final long serialVersionUID = 1L;
	private volatile static LazySingleton ton = null;
	
	private LazySingleton(){}
	
    public  static  LazySingleton lzTon() {
    	if(null == ton){
    		synchronized(LazySingleton.class){
    			if(null == ton)
    				ton = new LazySingleton();
    		}
    	}
    	return ton;
	}
}
