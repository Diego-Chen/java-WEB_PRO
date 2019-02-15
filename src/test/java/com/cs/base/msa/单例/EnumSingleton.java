/**
 * 
 */
package com.cs.base.msa.单例;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public enum EnumSingleton  implements Serializable {
	//枚举能规避序列化和线程安全的问题
	TON;
	public void fun(){
		System.out.println("枚举单例");
	}
}
