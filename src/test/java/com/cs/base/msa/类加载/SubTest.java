package com.cs.base.msa.类加载;

public class SubTest extends LoadTest{
	static{
		System.out.println("b");
	}
	
	public SubTest() {
		System.out.println("d");
	}
	
	public static void main(String[] args) {
		SubTest t1 = new SubTest();
		  t1 = new SubTest();
	}
	
}
