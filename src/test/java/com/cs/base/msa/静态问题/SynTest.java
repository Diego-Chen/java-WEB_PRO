package com.cs.base.msa.静态问题;


public class SynTest {
	static String name;
	
	
	/**
	 * 实例方法中可以使用静态变量，因为使用实例方法之前静态变量必然已经存在，可以使用。
	 */
	public void testName(){
		System.out.println(name);
	}
	
	
	private String status;
	
	/**
	 * 静态方法中不能使用实例变量，实例变量依赖于对象，在创建对象的时候才会有status变量的存在，而testStatus的调用完全可以在不创建对象的时候。
	 */
	static void testStatus(){
		//System.out.println(status);
	}

}
