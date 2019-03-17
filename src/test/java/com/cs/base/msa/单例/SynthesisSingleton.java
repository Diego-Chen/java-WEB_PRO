/**
 * 
 */
package com.cs.base.msa.单例;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class SynthesisSingleton implements Serializable{
	private static final long serialVersionUID = 1L;

	private static class Singleton{
		public static final SynthesisSingleton ton = new SynthesisSingleton();
	}
	
	public SynthesisSingleton() {}
	
	public static final SynthesisSingleton ssl(){
		return Singleton.ton;
	}
}
