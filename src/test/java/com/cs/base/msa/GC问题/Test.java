package com.cs.base.msa.GC问题;

public class Test {
	
	private Object instance = null;
	private static final int _1MB = 1024 * 1024;
	private byte[] bigSize = new byte[2*_1MB];
	
	public static void main(String[] args) {
		Test test1 = new Test();
		Test test2 = new Test();
		test1.instance = test2;
		test2.instance = test1;
		test1 = null;
		test2 = null;
		System.gc();
	}
}
