package com.cs.base.msa.静态问题;

/**
 * 非静态内部类不能含有静态成员变量
 * @author Administrator
 *
 */

public class SynthesisSingleton {
	
    private class Singleton{
        public static final String ton = "12345678" ;
    }
    
    public SynthesisSingleton() {}
    
    public static final String ssl(){
        return Singleton.ton;
    }
}
