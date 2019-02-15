/**
 * 
 */
package com.cs.base.msa.单例;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class HungrySingleton implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final HungrySingleton ton = new HungrySingleton();
	
	private HungrySingleton() {
		//防止反射
		if(null != ton){
			throw new RuntimeException();
		}
	}
	public static HungrySingleton hslton(){
		return ton;
	}
	private Object readResolve(){
		//防反序列化
		return ton;
	}
}
