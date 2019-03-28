package com.cs.base.msa.类加载;

public class LoadTest {
	static{
		System.out.println("a");
	}
	
	public LoadTest() {
		System.out.println("c");
	}
}
